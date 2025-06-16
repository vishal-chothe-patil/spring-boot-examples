package com.expertise.swagger.example.service.impl;

import com.expertise.swagger.example.model.Book;
import com.expertise.swagger.example.service.BookServiceI;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookServiceI {

    private final Map<Integer, Book> bookStore = new HashMap<>();
    private int idCounter = 1;

    @Override
    public String addBook(Book book) {
        book.setId(idCounter++);
        bookStore.put(book.getId(), book);
        return "Book added with ID: " + book.getId();
    }

    @Override
    public Book getBookById(int id) {
        Book book = bookStore.get(id);
        if (book == null) {
            throw new NoSuchElementException("Book not found with ID: " + id);
        }
        return book;
    }

    @Override
    public Collection<Book> getAllBooks() {
        return bookStore.values();
    }

    @Override
    public String deleteBookById(int id) {
        if (bookStore.remove(id) != null) {
            return "Book deleted with ID: " + id;
        } else {
            return "Book not found with ID: " + id;
        }
    }
}
