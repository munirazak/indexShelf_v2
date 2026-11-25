package com.kopibru.librarysystem.controller;

import com.kopibru.librarysystem.dto.BookDto;
import com.kopibru.librarysystem.dto.BorrowRequest;
import com.kopibru.librarysystem.security.AuthenticationUtils;
import com.kopibru.librarysystem.service.BookService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * List books — SUPER_ADMIN only (enforced by SecurityConfig). Forwards to BookManagement.
     */
    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks(
            @RequestParam(defaultValue = "all") String status) {
        log.info("GET /api/books status={}", status);
        List<BookDto> books = bookService.getBooks(status);
        log.info("Returning {} books for status={}", books.size(), status);
        return ResponseEntity.ok(books);
    }

    /**
     * Register a book — SUPER_ADMIN only (enforced by SecurityConfig). Forwards to BookManagement.
     */
    @PostMapping
    public ResponseEntity<BookDto> registerBook(@Valid @RequestBody BookDto book) {
        log.info("POST /api/books id={} isbn={}", book.getId(), book.getIsbn());
        BookDto registered = bookService.register(book);
        log.info("Book registered id={} isbn={} status={}",
                registered.getId(), registered.getIsbn(), registered.getStatus());
        return ResponseEntity.status(HttpStatus.CREATED).body(registered);
    }

    @PostMapping("/borrow")
    public ResponseEntity<BookDto> borrowBook(@Valid @RequestBody BorrowRequest request) {
        String libraryId = AuthenticationUtils.requireLibraryId();
        log.info("POST /api/books/borrow libraryId={} bookId={}", libraryId, request.getBookId());
        BookDto result = bookService.borrow(libraryId, request);
        log.info("Borrow completed libraryId={} bookId={} status={}", libraryId, result.getId(), result.getStatus());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/return")
    public ResponseEntity<BookDto> returnBook(@Valid @RequestBody BorrowRequest request) {
        String libraryId = AuthenticationUtils.requireLibraryId();
        log.info("POST /api/books/return libraryId={} bookId={}", libraryId, request.getBookId());
        BookDto result = bookService.returnBook(libraryId, request);
        log.info("Return completed libraryId={} bookId={} status={}", libraryId, result.getId(), result.getStatus());
        return ResponseEntity.ok(result);
    }
}
