package com.cyfrifpro.restcontrollers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyfrifpro.model.Role;
import com.cyfrifpro.payloads.UserDTO;
import com.cyfrifpro.services.UserService;
import com.cyfrifpro.services.impl.RateLimitService;
import com.cyfrifpro.util.SecurityUtils;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "Mutual fund distributor App")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private RateLimitService rateLimitService;

	@GetMapping("/filter")
	public ResponseEntity<List<UserDTO>> getFilteredUsers(@RequestParam String filterType) {

		Long creatorUserId = SecurityUtils.getLoggedInUserId();

		try {
			// Fetch the filtered users
			List<UserDTO> filteredUsers = userService.getFilteredUsers(filterType, creatorUserId);
			return new ResponseEntity<>(filteredUsers, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(Collections.emptyList(), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception for debugging
			return new ResponseEntity<>(Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/subordinates")
	public ResponseEntity<List<UserDTO>> getAllUsersUnder() {
	    Long loggedInUserId = SecurityUtils.getLoggedInUserId();

	    // Check if the request is allowed based on rate limiting
	    if (!rateLimitService.isRequestAllowed(loggedInUserId)) {
	        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
	                             .body(Collections.emptyList());
	    }

	    List<UserDTO> subordinatesTree = userService.getAllUsersUnder(loggedInUserId);
	    return ResponseEntity.ok(subordinatesTree);
	}

	// Endpoint to get a user by ID with downline access check
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
		Long loggedInUserId = SecurityUtils.getLoggedInUserId();
		UserDTO user = userService.getUserById(loggedInUserId, userId);
		return ResponseEntity.ok(user);
	}

	// Endpoint to update a user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
		Long loggedInUserId = SecurityUtils.getLoggedInUserId();
		UserDTO updatedUser = userService.updateUser(loggedInUserId, userId, userDTO);
		return ResponseEntity.ok(updatedUser);
	}

	// Endpoint to delete a user
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		Long loggedInUserId = SecurityUtils.getLoggedInUserId();
		String response = userService.deleteUser(loggedInUserId, userId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/admin/roles")
	public ResponseEntity<List<Role>> getAllRoles() {
		List<Role> roles = userService.getAllRoles();

		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

}