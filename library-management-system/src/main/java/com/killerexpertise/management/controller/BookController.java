package com.killerexpertise.management.controller;

import com.killerexpertise.management.model.Book;
import com.killerexpertise.management.service.BookService;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;   // Add this
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Setter
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public String createBook(@RequestBody Book book) {
        logger.info("Request received to create a new book: {}", book.getTitle());
        bookService.addBook(book);
        logger.info("Book created successfully: {}", book.getTitle());
        return "Book created successfully!";
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        logger.info("Request received to fetch all books.");
        return bookService.getAllBooks();
    }

    @GetMapping("/get/{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        logger.info("Request received to fetch book with ID: {}", bookId);
        return bookService.getBookById(bookId);
    }

    @PutMapping("/update/{bookId}")
    public String updateBookDetails(@PathVariable int bookId, @RequestBody Book updatedBook) {
        logger.info("Request received to update book with ID: {}", bookId);
        updatedBook.setBid(bookId);
        bookService.updateBook(bookId, updatedBook);
        logger.info("Book updated successfully with ID: {}", bookId);
        return "Book details updated successfully!";
    }

    @DeleteMapping("/delete/{bookId}")
    public String removeBook(@PathVariable int bookId) {
        logger.warn("Request received to delete book with ID: {}", bookId); // Using warn here
        bookService.deleteBook(bookId);
        logger.info("Book removed successfully with ID: {}", bookId);
        return "Book removed successfully!";
    }
}
