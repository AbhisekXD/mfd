package com.cyfrifpro.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cyfrifpro.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoConfig implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String email;
    private String password;
    private List<GrantedAuthority> authorities;
    
    

    public UserInfoConfig(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        if (user.getRole() == null || user.getRole().getRoleName() == null) {
            throw new IllegalArgumentException("User role or role name is missing");
        }
        this.authorities = List.of(
            new SimpleGrantedAuthority("ROLE_" + user.getRole().getRoleName())
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Can add logic to handle account expiry
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Can add logic to handle account locking
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Can add logic to handle credential expiry
    }

    @Override
    public boolean isEnabled() {
        return true; // Can add logic to handle account enable/disable
    }
}

