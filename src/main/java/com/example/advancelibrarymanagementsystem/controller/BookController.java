package com.example.advancelibrarymanagementsystem.controller;


import com.example.advancelibrarymanagementsystem.entitites.Book;
import com.example.advancelibrarymanagementsystem.exceptionHandling.ResourceNotFoundException;
import com.example.advancelibrarymanagementsystem.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    private static  final String NOTFOUND = "Book not found with id: ";

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Optional<Book> book = bookService.findBookById(id);
        if (book.isEmpty()) {
            throw new ResourceNotFoundException(NOTFOUND + id);
        }
        Book updatedBook = bookService.updateBook(id, bookDetails);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> book = bookService.findBookById(id);
        if (book.isEmpty()) {
            throw new ResourceNotFoundException(NOTFOUND + id);
        }
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NOTFOUND + id));
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }
}
