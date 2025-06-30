package com.example.demo.service;

import com.example.demo.model.entity.Books;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public Books getBookById(Long BookId) {
        return bookRepository.findById(BookId)
                .orElse(null);
    }

    public Books saveBook(Books book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long BookId) {
        bookRepository.deleteById(BookId);
    }

    public Books updateBook(Books book) {
        Books existingBook = bookRepository.findById(book.getId())
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + book.getId()));


        if (book.getTitle() != null) {
            existingBook.setTitle(book.getTitle());
        }
        if (book.getAuthor() != null) {
            existingBook.setAuthor(book.getAuthor());
        }
        if (book.getIsbn() != null) {
            existingBook.setIsbn(book.getIsbn());
        }
        if (book.getPrice() != null) {
            existingBook.setPrice(book.getPrice());
        }
        if (book.getPublishedYear() != null) {
            existingBook.setPublishedYear(book.getPublishedYear());
        }
        if (book.getAvailable() != null) {
            existingBook.setAvailable(book.getAvailable());
        }

        return bookRepository.save(existingBook);
    }

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

}

