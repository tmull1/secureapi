package com.example.secureapi;

public class JwtRequest {
    private String username;
    private String password;

    // Default constructor for JSON Parsing
    public JwtRequest() {}

    // Constructor with fields
    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

