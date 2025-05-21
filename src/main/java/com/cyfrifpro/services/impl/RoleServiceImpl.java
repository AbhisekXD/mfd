package com.cyfrifpro.services.impl;

import com.cyfrifpro.model.Role;
import com.cyfrifpro.model.User;
import com.cyfrifpro.model.enums.RoleEnum;
import com.cyfrifpro.repositories.RoleRepo;
import com.cyfrifpro.repositories.UserRepo;
import com.cyfrifpro.services.RoleService;
import com.cyfrifpro.util.SecurityUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private UserRepo userRepo;

	/**
	 * Assigns a role to a user, validating the role hierarchy and updating the
	 * closure table.
	 */
	@Override
	public void assignRole(Long parentRoleId, Long userId, RoleEnum roleToAssign) {
	    // Get the logged-in user's ID
	    Long loggedInUserId = SecurityUtils.getLoggedInUserId();

	    // Get the parent role ID from the logged-in user's ID
	    parentRoleId = getRoleIdFromUserId(loggedInUserId);

	    // Fetch the parent role using the retrieved parentRoleId
	    Role parentRole = roleRepo.findById(parentRoleId)
	            .orElseThrow(() -> new IllegalArgumentException("Parent role not found"));

	    // Validate if the role assignment is allowed based on hierarchy
	    if (!canAssignRole(parentRole.getRoleName(), roleToAssign)) {
	        throw new IllegalArgumentException("Role assignment not allowed");
	    }

	    // Fetch the child role (role to assign)
	    Role childRole = roleRepo.findByRoleName(roleToAssign)
	            .orElseThrow(() -> new IllegalArgumentException("Role not found"));

	    // Fetch the user to assign the new role
	    User user = userRepo.findById(userId)
	            .orElseThrow(() -> new IllegalArgumentException("User not found"));

	    // Set the new role for the user
	    user.setRole(childRole);
	    userRepo.save(user);
	    
	}

	@Override
	public Long getRoleIdFromUserId(Long userId) {
		// Fetch the user by their ID
		User user = userRepo.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

		// Get the role associated with the user
		Role role = user.getRole();
		if (role != null) {
			return role.getRoleId(); // Return the roleId
		} else {
			throw new IllegalArgumentException("User has no role assigned");
		}
	}

	/**
	 * Validates if a parent role can assign a given child role.
	 */
	@Override
	public boolean canAssignRole(RoleEnum parentRole, RoleEnum childRole) {
		return switch (parentRole) {
		case MASTER_ADMIN -> childRole == RoleEnum.CONTROL_PANEL;
		case CONTROL_PANEL -> childRole == RoleEnum.DISTRIBUTOR;
		case DISTRIBUTOR -> childRole == RoleEnum.RELATIONSHIP_MANAGER || childRole == RoleEnum.CLIENT;
		default -> false;
		};
	}

	/**
	 * Fetches all users assigned to a specific role.
	 */
	@Override
	public List<User> getUsersByRole(RoleEnum roleEnum) {
		return userRepo.findByRoleRoleName(roleEnum);
	}

	/**
	 * Fetches all roles from the system.
	 */
	@Override
	public List<Role> getAllRoles() {
		return roleRepo.findAll();
	}
	
}
