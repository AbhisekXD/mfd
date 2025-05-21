package com.cyfrifpro.config.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cyfrifpro.services.impl.UserDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            try {
                var claims = jwtUtil.validateTokenAndRetrieveClaims(jwt);
                Long userId = ((Number) claims.get("userId")).longValue();
                String email = (String) claims.get("email");
                String roleName = (String) claims.get("roleName");

                //UserDetails userDetails = 
                		userDetailsServiceImpl.loadUserByUsername(email);
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + roleName);

                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(userId, null, List.of(authority))
                );
                request.setAttribute("userId", userId);

            } catch (JWTVerificationException e) {
                response.sendError(
                        e.getMessage().contains("expired") 
                                ? HttpServletResponse.SC_UNAUTHORIZED 
                                : HttpServletResponse.SC_BAD_REQUEST, 
                        e.getMessage());
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
