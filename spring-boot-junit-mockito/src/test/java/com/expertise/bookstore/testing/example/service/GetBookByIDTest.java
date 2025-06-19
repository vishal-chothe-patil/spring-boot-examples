package com.expertise.bookstore.testing.example.service;

import com.expertise.bookstore.testing.example.model.Book;
import com.expertise.bookstore.testing.example.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetBookByIDTest {

    private static final Logger logger = LoggerFactory.getLogger(GetBookByIDTest.class);

    @Mock
    private BookRepository bookRepository;  // Mocked dependency

    @InjectMocks
    private BookServiceI bookServiceI;       // The class we are testing

    @Test
    void testGetBookById_BookExists() {
        logger.info("Running test: testGetBookById_BookExists");

        // Given
        Book mockBook = new Book(1L, "Java Basics", "Vishal Chothe");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(mockBook));

        // When
        Book book = bookServiceI.getBookById(1L);

        // Then
        assertEquals("Java Basics", book.getTitle());
        assertEquals("Vishal Chothe", book.getAuthor());
        verify(bookRepository, times(1)).findById(1L);

        logger.info("Test testGetBookById_BookExists passed successfully.");
    }

    @Test
    void testGetBookById_BookNotFound() {
        logger.info("Running test: testGetBookById_BookNotFound");

        // Given
        when(bookRepository.findById(2L)).thenReturn(Optional.empty());

        // Then
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            bookServiceI.getBookById(2L);
        });

        assertEquals("Book not found", exception.getMessage());

        logger.info("Test testGetBookById_BookNotFound passed successfully.");
    }
}
