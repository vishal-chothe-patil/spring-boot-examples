package com.expertise.swagger.example.service;

import com.expertise.swagger.example.model.Book;

import java.util.Collection;

public interface BookServiceI {
    String addBook(Book book);

    Book getBookById(int id);

    Collection<Book> getAllBooks();

    String deleteBookById(int id);
}
