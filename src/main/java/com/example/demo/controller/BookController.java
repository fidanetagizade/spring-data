package com.example.demo.controller;
import com.example.demo.model.entity.Books;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/{booksId}")
    public ResponseEntity<?> getBooksById(@PathVariable Long booksId) {
        Books book = bookService.getBookById(booksId);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody @Valid Books book) {
        Books savedBook = bookService.saveBook(book);
        return ResponseEntity.ok(savedBook);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBookById(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody @Valid Books book) {
        book.setId(id);
        Books updatedBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        List<Books> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

}


