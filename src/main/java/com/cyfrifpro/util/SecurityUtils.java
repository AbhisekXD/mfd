package com.cyfrifpro.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    private SecurityUtils() {
        // Prevent instantiation using non-static block
    }

    public final static Long getLoggedInUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof Long) {
            return (Long) principal;
        } else if (principal instanceof String) {
            try {
                return Long.parseLong((String) principal);  // Handle case where principal is a String
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Principal cannot be converted to Long: " + principal);
            }
        } else {
            throw new IllegalStateException("Principal type not recognized: " + principal.getClass());
        }
    }
}