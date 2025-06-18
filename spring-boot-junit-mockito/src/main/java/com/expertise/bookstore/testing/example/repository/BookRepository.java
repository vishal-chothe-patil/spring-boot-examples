package com.expertise.bookstore.testing.example.repository;

import com.expertise.bookstore.testing.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
