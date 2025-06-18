package com.expertise.bookstore.testing.example.controller;

import com.expertise.bookstore.testing.example.model.Book;
import com.expertise.bookstore.testing.example.service.BookServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookServiceI bookServiceI;

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookServiceI.addBook(book);
    }

}