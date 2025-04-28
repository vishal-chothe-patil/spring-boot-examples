package com.killerexpertise.management.service;

import com.killerexpertise.management.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(int id);

    void updateBook(int id, Book book);

    void deleteBook(int id);
}
