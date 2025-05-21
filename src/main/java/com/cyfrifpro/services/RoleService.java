package com.cyfrifpro.services;

import com.cyfrifpro.model.Role;
import com.cyfrifpro.model.User;
import com.cyfrifpro.model.enums.RoleEnum;

import java.util.List;

public interface RoleService {

    /**
     * Assigns a role to a user, validating the role hierarchy and updating the closure table.
     */
    void assignRole(Long parentRoleId, Long userId, RoleEnum roleToAssign);

    /**
     * Fetches the role ID for a given user ID.
     */
    Long getRoleIdFromUserId(Long userId);

    /**
     * Validates if a parent role can assign a given child role.
     */
    boolean canAssignRole(RoleEnum parentRole, RoleEnum childRole);

    /**
     * Fetches all users assigned to a specific role.
     */
    List<User> getUsersByRole(RoleEnum roleEnum);

    /**
     * Fetches all roles from the system.
     */
    List<Role> getAllRoles();
}
