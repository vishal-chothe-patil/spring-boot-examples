package com.killerexpertise.management.repository;

import com.killerexpertise.management.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    private Map<Integer, Book> bookStore = new HashMap<>();

    public void save(Book book) {
        bookStore.put(book.getBid(), book);
    }

    public List<Book> findAll() {
        return new ArrayList<>(bookStore.values());
    }

    public Book findById(int id) {
        return bookStore.get(id);
    }

    public void deleteById(int id) {
        bookStore.remove(id);
    }
}
