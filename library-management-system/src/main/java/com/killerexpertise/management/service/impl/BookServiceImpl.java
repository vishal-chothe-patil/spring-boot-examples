package com.killerexpertise.management.service.impl;

import com.killerexpertise.management.model.Book;
import com.killerexpertise.management.repository.BookRepository;
import com.killerexpertise.management.service.BookService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void updateBook(int id, Book book) {
        book.setBid(id);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
