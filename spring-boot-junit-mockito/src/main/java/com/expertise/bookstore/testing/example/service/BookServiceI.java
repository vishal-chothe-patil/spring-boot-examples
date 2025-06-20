package com.expertise.bookstore.testing.example.service;

import com.expertise.bookstore.testing.example.model.Book;

import java.util.List;

public interface BookServiceI {

    Book addBook(Book book);

    Book getBookById(Long id);

    List<Book> getAllBooks();
}
