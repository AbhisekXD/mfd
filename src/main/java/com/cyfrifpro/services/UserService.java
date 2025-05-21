package com.cyfrifpro.services;

import java.util.List;

import com.cyfrifpro.model.Role;
import com.cyfrifpro.payloads.UserDTO;


public interface UserService {

    // Registers a new user with a creator (if any)
    UserDTO registerUser(UserDTO userDTO, Long creatorUserId);

    // Fetches a list of users based on the specified filter
    List<UserDTO> getFilteredUsers(String filterType, Long creatorUserId);

    // Fetches all users under a specific user (their downline)
    List<UserDTO> getAllUsersUnder(Long loggedInUserId);

    // Fetches a single user by ID, only if the user is part of the logged-in user's downline
    UserDTO getUserById(Long loggedInUserId, Long userId);

    // Updates the user details
    UserDTO updateUser(Long loggedInUserId, Long userId, UserDTO userDTO);

    // Deletes a user if they are part of the logged-in user's downline
    String deleteUser(Long loggedInUserId, Long userId);

	List<Role> getAllRoles();
}
