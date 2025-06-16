package com.expertise.swagger.example.controller;

import com.expertise.swagger.example.model.Book;
import com.expertise.swagger.example.service.BookServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookServiceI bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/all")
    public Collection<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBookById(@PathVariable int id) {
        return bookService.deleteBookById(id);
    }
}
