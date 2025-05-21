package com.cyfrifpro.restcontrollers;

import com.cyfrifpro.model.Role;
import com.cyfrifpro.model.User;
import com.cyfrifpro.model.enums.RoleEnum;
import com.cyfrifpro.services.RoleService;
import com.cyfrifpro.util.SecurityUtils;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * Assign a role to a user.
     *
     * @param parentId    ID of the parent role
     * @param userId      ID of the user
     * @param roleToAssign Role to assign
     * @return ResponseEntity with the status of the request
     */
    @PostMapping("/assign")
    public ResponseEntity<String> assignRole(
            @RequestParam Long userId, 
            @RequestParam RoleEnum roleToAssign,
            Authentication authentication) { // Inject Authentication for accessing logged-in user

        try {
            // Get the logged-in user ID from the security context
            //Long loggedInUserId = 
            		SecurityUtils.getLoggedInUserId(); 

            // Call the service method to assign the role
            roleService.assignRole(null, userId, roleToAssign); // Passing null for parentRoleId to use logged-in user's role as the parent
            return ResponseEntity.ok("Role assigned successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Get all users assigned to a specific role.
     *
     * @param roleEnum Role to search for
     * @return List of users assigned to the role
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsersByRole(@RequestParam RoleEnum roleEnum) {
        List<User> users = roleService.getUsersByRole(roleEnum);
        return ResponseEntity.ok(users);
    }


    /**
     * Get all roles in the system.
     *
     * @return List of all roles
     */
    @GetMapping("/allRoles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    /**
     * Get all users within the scope of a specific role.
     *
     * @param roleId Role ID to check for users within scope
     * @return List of users within the scope of the given role
     */
}
