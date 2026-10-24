package com.kopibru.librarysystem.model;

public class Borrower {

    private Long id;
    private String libraryId;
    private String name;
    private String email;
    private String role;

    public Borrower() {
    }

    public Borrower(String libraryId, String name, String email) {
        this.libraryId = libraryId;
        this.name = name;
        this.email = email;
        this.role = "BORROWER";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
