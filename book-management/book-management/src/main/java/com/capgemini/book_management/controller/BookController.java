package com.capgemini.book_management.controller;

import com.capgemini.book_management.model.Book;
import com.capgemini.book_management.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookTitle(@PathVariable Long id, @RequestBody String title) {
        return new ResponseEntity<>(bookService.updateBookTitle(id, title), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }
}
