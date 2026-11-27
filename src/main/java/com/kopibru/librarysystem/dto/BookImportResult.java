package com.kopibru.librarysystem.dto;

import java.util.ArrayList;
import java.util.List;

public class BookImportResult {

    private List<BookDto> registered = new ArrayList<>();
    private List<String> errors = new ArrayList<>();

    public BookImportResult() {
    }

    public BookImportResult(List<BookDto> registered, List<String> errors) {
        this.registered = registered != null ? registered : new ArrayList<>();
        this.errors = errors != null ? errors : new ArrayList<>();
    }

    public List<BookDto> getRegistered() {
        return registered;
    }

    public void setRegistered(List<BookDto> registered) {
        this.registered = registered;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
