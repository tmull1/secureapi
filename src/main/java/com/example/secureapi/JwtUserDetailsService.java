package com.example.secureapi;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return User.withUsername("admin").password("{noop}admin").roles("ADMIN").build();
        } else if ("user".equals(username)) {
            return User.withUsername("user").password("{noop}password").roles("USER").build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}

