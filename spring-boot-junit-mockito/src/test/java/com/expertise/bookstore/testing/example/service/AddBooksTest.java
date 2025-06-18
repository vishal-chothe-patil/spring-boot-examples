package com.expertise.bookstore.testing.example.service;

import com.expertise.bookstore.testing.example.model.Book;
import com.expertise.bookstore.testing.example.repository.BookRepository;
import com.expertise.bookstore.testing.example.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddBooksTest {

    private static final Logger logger = LoggerFactory.getLogger(AddBooksTest.class);

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookServiceI;

    @Test
    void testAddBook() {
        // Given
        Book inputBook = new Book(null, "Spring Boot Junit 101", "Vishal Chothe");
        logger.info("Input Book: {}", inputBook);

        // When
        Book savedBook = new Book(1L, "Spring Boot Junit 101", "Vishal Chothe");
        when(bookRepository.save(inputBook)).thenReturn(savedBook);

        Book result = bookServiceI.addBook(inputBook);
        logger.info("Result Book after save: {}", result);

        // Then
        assertNotNull(result.getId());
        assertEquals("Spring Boot Junit 101", result.getTitle());

        verify(bookRepository, times(1)).save(inputBook);
        logger.info("Verified repository.save() was called once");
    }

}