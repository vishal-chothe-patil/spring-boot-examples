package com.expertise.bookstore.testing.example.controller;

import com.expertise.bookstore.testing.example.model.Book;
import com.expertise.bookstore.testing.example.service.BookServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookServiceI bookServiceI;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookServiceI.addBook(book);
    }

    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookServiceI.getBookById(id);
    }

    @GetMapping("/getAll")
    public List<Book> getAllBooks() {
        return bookServiceI.getAllBooks();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookServiceI.deleteBook(id);
        return "Book with ID " + id + " deleted successfully.";
    }
}