package com.example.secureapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Map;  // Import Map
import java.util.HashMap;  // Import HashMap

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Sample user repository for demo purposes (simulate database storage)
    private Map<String, String> users = new HashMap<>();  // Username -> Encoded Password

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final String token = jwtTokenUtil.generateToken(authenticationRequest.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            throw new Exception("Authentication failed", e);
        }
    }

    // Register new users
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody JwtRequest registerRequest) {
        // Encode the password and store it
        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        users.put(registerRequest.getUsername(), encodedPassword);

        return ResponseEntity.ok("User registered successfully");
    }

    // Generate token (optional)
    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final String token = jwtTokenUtil.generateToken(authenticationRequest.getUsername());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    // Admin-only endpoint
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getAdminResource() {
        return ResponseEntity.ok("This is the Admin resource.");
    }

    // User-only endpoint
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getUserResource() {
        return ResponseEntity.ok("This is the User resource.");
    }

    // Accessible by both Admin and User
    @GetMapping("/common")
    public ResponseEntity<String> getCommonResource() {
        return ResponseEntity.ok("This is the Common resource accessible to all authenticated users.");
    }
}







