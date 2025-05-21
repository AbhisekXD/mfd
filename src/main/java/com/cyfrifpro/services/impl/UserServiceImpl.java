package com.cyfrifpro.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cyfrifpro.exceptions.APIException;
import com.cyfrifpro.exceptions.ResourceNotFoundException;
import com.cyfrifpro.model.Role;
import com.cyfrifpro.model.User;
import com.cyfrifpro.payloads.UserDTO;
import com.cyfrifpro.repositories.RoleRepo;
import com.cyfrifpro.repositories.UserRepo;
import com.cyfrifpro.services.UserService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final RateLimitService rateLimitService;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(RateLimitService rateLimitService,UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder,
            ModelMapper modelMapper) {
    	this.rateLimitService = rateLimitService;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    @CacheEvict(value = "userCache", key = "#loggedInUserId + '-' + #userId")
    @CachePut(value = "userCache", key = "#loggedInUserId + '-' + #userId") // Update cache after eviction
    public UserDTO registerUser(UserDTO userDTO, Long creatorUserId) {
        try {
            User user = modelMapper.map(userDTO, User.class);
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            if (userRepo.count() == 0) {
                user.setCreatedBy(null);
            } else {
                if (creatorUserId == null) {
                    throw new APIException("Creator ID is required for this operation.");
                }
                User creator = userRepo.findById(creatorUserId)
                        .orElseThrow(() -> new APIException("Creator not found for userId: " + creatorUserId));
                user.setCreatedBy(creator);
            }

            User registeredUser = userRepo.save(user);
            return modelMapper.map(registeredUser, UserDTO.class);
        } catch (DataIntegrityViolationException e) {
            throw new APIException("User already exists with emailId: " + userDTO.getEmail());
        }
    }

    @Override
    @Cacheable(value = "filteredUsersCache", key = "#filterType + '-' + #creatorUserId")
    public List<UserDTO> getFilteredUsers(String filterType, Long creatorUserId) {
        List<User> users;
        if ("all".equalsIgnoreCase(filterType)) {
            users = userRepo.findByCreatedBy_UserId(creatorUserId);
        } else if ("no-role".equalsIgnoreCase(filterType)) {
            users = userRepo.findByCreatedBy_UserIdAndRoleIsNull(creatorUserId);
        } else if ("with-role".equalsIgnoreCase(filterType)) {
            users = userRepo.findByCreatedBy_UserIdAndRoleIsNotNull(creatorUserId);
        } else {
            throw new IllegalArgumentException("Invalid filter type: " + filterType);
        }

        return users.stream().map(user -> {
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            userDTO.setRoleName(user.getRole() != null ? user.getRole().getRoleName() : null);
            return userDTO;
        }).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "subordinatesCache", key = "#loggedInUserId")
    public List<UserDTO> getAllUsersUnder(Long loggedInUserId) {
        // Check if the request is allowed based on rate limiting
        if (!rateLimitService.isRequestAllowed(loggedInUserId)) {
            // You can return null or an empty list here if you prefer not to throw an exception
            return Collections.emptyList(); // Or you could return a response with a 429 status
        }

        User loggedInUser = userRepo.findById(loggedInUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", loggedInUserId));

        // Fetch all users under the logged-in user (excluding the logged-in user itself)
        List<UserDTO> allUsers = new ArrayList<>();

        // Recursively add subordinates (excluding the logged-in user)
        Set<Long> addedUsers = new HashSet<>();
        addedUsers.add(loggedInUserId); // Ensure the logged-in user isn't added
        addSubordinatesRecursive(loggedInUser, allUsers, addedUsers);

        return allUsers;
    }

    private void addSubordinatesRecursive(User user, List<UserDTO> allUsers, Set<Long> addedUsers) {
        List<User> subordinates = userRepo.findAllByCreatedBy(user);

        for (User subordinate : subordinates) {
            if (!addedUsers.contains(subordinate.getUserId())) {
                UserDTO userDTO = modelMapper.map(subordinate, UserDTO.class);
                userDTO.setRoleName(subordinate.getRole() != null ? subordinate.getRole().getRoleName() : null);

                // Add to the set of added users to avoid duplicates
                addedUsers.add(subordinate.getUserId());

                // Recursively map subordinates for each subordinate
                userDTO.setSubordinates(new ArrayList<>());
                addSubordinatesRecursive(subordinate, userDTO.getSubordinates(), addedUsers);

                // Add the subordinate to the main list
                allUsers.add(userDTO);
            }
        }
    }

    private boolean isUserInDownline(Long loggedInUserId, Long targetUserId) {
        List<UserDTO> downline = getAllUsersUnder(loggedInUserId);
        return downline.stream().anyMatch(user -> user.getUserId().equals(targetUserId));
    }


    @Override
    @Cacheable(value = "userCache", key = "#loggedInUserId + '-' + #userId")
    public UserDTO getUserById(Long loggedInUserId, Long userId) {
        if (!isUserInDownline(loggedInUserId, userId)) {
            throw new APIException("Access Denied: User is not in your downline.");
        }
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    @CacheEvict(value = "userCache", key = "#loggedInUserId + '-' + #userId")
    @CachePut(value = "userCache", key = "#loggedInUserId + '-' + #userId") // Update cache after eviction
    public UserDTO updateUser(Long loggedInUserId, Long userId, UserDTO userDTO) {
        if (!isUserInDownline(loggedInUserId, userId)) {
            throw new APIException("Access Denied: User is not in your downline.");
        }
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setContactNumber(userDTO.getContactNumber());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User updatedUser = userRepo.save(user); // Save updated user
        return modelMapper.map(updatedUser, UserDTO.class); // Return updated user DTO
    }

    @Override
    @CacheEvict(value = "userCache", key = "#loggedInUserId + '-' + #userId")
    @CachePut(value = "userCache", key = "#loggedInUserId + '-' + #userId")
    public String deleteUser(Long loggedInUserId, Long userId) {
        if (!isUserInDownline(loggedInUserId, userId)) {
            throw new APIException("Access Denied: User is not in your downline.");
        }
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        userRepo.delete(user);
        return "User with userId " + userId + " deleted successfully!!!";
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }
}