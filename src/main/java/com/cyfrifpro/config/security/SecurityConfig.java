package com.cyfrifpro.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cyfrifpro.config.AppConstants;
import com.cyfrifpro.services.impl.UserDetailsServiceImpl;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Autowired
	private JWTFilter jwtFilter;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
	    http
	        // Disable CSRF for stateless JWT-based security
	        .csrf(csrf -> csrf.disable())
	 
	        // Configure authorization rules dynamically based on roles
	        .authorizeHttpRequests(requests -> {
	            // Public URLs accessible to all
	            requests.requestMatchers(AppConstants.PUBLIC_URLS).permitAll();
	            
	            // Dynamically assign URLs to roles
	            AppConstants.ROLE_URLS.forEach((role, urls) -> 
	                requests.requestMatchers(urls).hasAuthority(role.name())
	            );
	            
	            // All other requests require authentication
	            requests.anyRequest().authenticated();
	        })
	        
	        // Exception handling for unauthorized access
	        .exceptionHandling(handling -> 
	            handling.authenticationEntryPoint(
	                (request, response, authException) -> 
	                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
	            )
	        )
	        
	        // Stateless session management
	        .sessionManagement(management -> 
	            management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        );
	    
	    // Add JWT filter before username-password authentication filter
	    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	    
	    // Use custom DAO authentication provider
	    http.authenticationProvider(daoAuthenticationProvider());
	    
	    // Build and return the security filter chain
	    return http.build();
	}


    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsServiceImpl);
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
	}

    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
}