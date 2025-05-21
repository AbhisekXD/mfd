package com.cyfrifpro.restcontrollers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyfrifpro.config.security.JWTUtil;
import com.cyfrifpro.exceptions.APIException;
import com.cyfrifpro.model.User;
import com.cyfrifpro.payloads.LoginCredentials;
import com.cyfrifpro.payloads.UserDTO;
import com.cyfrifpro.repositories.UserRepo;
import com.cyfrifpro.services.UserService;
import com.cyfrifpro.services.impl.RateLimitService;
import com.cyfrifpro.util.SecurityUtils;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "Mutual fund distributor App")
public class AuthController {

	@Autowired
	private UserService userService;

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RateLimitService rateLimitService;

	@GetMapping("/some-api")
	public String someApi(@RequestParam Long userId) {
		if (rateLimitService.isRequestAllowed(userId)) {
			return "Request allowed";
		} else {
			return "Rate limit exceeded";
		}
	}

	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> registerHandler(@Valid @RequestBody UserDTO userDTO) {
		try {
			Long creatorUserId = null;

			// Check if it's not the first user
			if (userRepo.count() > 0) {
				// Fetch the creator's userId from the SecurityContext
				creatorUserId = SecurityUtils.getLoggedInUserId();
			}

			// Register the user
			UserDTO registeredUser = userService.registerUser(userDTO, creatorUserId);

			// Generate a JWT token for the newly registered user with the default "USER"
			// role
			String token = jwtUtil.generateToken(registeredUser.getUserId(), // Registered user's ID
					registeredUser.getEmail(), "USER");

			// Return the token in the response
			return new ResponseEntity<>(Collections.singletonMap("jwt-token", token), HttpStatus.CREATED);
		} catch (APIException e) {
			return new ResponseEntity<>(Collections.singletonMap("error", e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<>(Collections.singletonMap("error", "An unexpected error occurred"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> loginHandler(@Valid @RequestBody LoginCredentials credentials) {
		try {
			// Authenticate user credentials
			UsernamePasswordAuthenticationToken authCredentials = new UsernamePasswordAuthenticationToken(
					credentials.getEmail(), credentials.getPassword());

			Authentication auth = authenticationManager.authenticate(authCredentials);

			// Fetch the authenticated user's details
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			String email = userDetails.getUsername();

			// Retrieve the user's role from their granted authorities
			String roleName = userDetails.getAuthorities().stream().findFirst()
					.map(authority -> authority.getAuthority().replace("ROLE_", "")).orElse("USER"); // Default to
																										// "USER" if no
																										// role is found

			// Fetch the user from the database to get the user ID
			Optional<User> optionalUser = userRepo.findByEmail(email);

			if (!optionalUser.isPresent()) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
						.body(Collections.singletonMap("error", "User not found"));
			}

			User user = optionalUser.get();
			Long userId = user.getUserId(); // Assuming User entity has an ID field

			// Generate JWT token with userId, email, and role
			String token = jwtUtil.generateToken(userId, email, roleName); // Now using the userId, email, and roleName

			// Return the JWT token and user ID in the response
			Map<String, Object> response = new HashMap<>();
			response.put("jwt-token", token);
			// response.put("userId", userId); // Include userId in the response

			return ResponseEntity.ok(response);
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(Collections.singletonMap("error", "Invalid email or password"));
		}
	}

}