package com.kopibru.librarysystem.dto;

public class LoginResponse {

    private String token;
    private String libraryId;
    private String username;
    private String role;

    public LoginResponse() {
    }

    public LoginResponse(String token, String libraryId, String username) {
        this(token, libraryId, username, "BORROWER");
    }

    public LoginResponse(String token, String libraryId, String username, String role) {
        this.token = token;
        this.libraryId = libraryId;
        this.username = username;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
