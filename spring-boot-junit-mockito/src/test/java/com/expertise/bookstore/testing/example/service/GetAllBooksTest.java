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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetAllBooksTest {

    private static final Logger logger = LoggerFactory.getLogger(GetAllBooksTest.class);

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookServiceI;

    @Test
    void testGetAllBooks_ReturnsListOfBooks() {
        logger.info("Running test: testGetAllBooks_ReturnsListOfBooks");

        // Given
        List<Book> mockBooks = Arrays.asList(
                new Book(1L, "Java Basics", "Vishal"),
                new Book(2L, "Spring Boot Advanced", "Chothe")
        );
        when(bookRepository.findAll()).thenReturn(mockBooks);

        // When
        List<Book> result = bookServiceI.getAllBooks();
        logger.info("Fetched books: {}", result);

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Java Basics", result.get(0).getTitle());

        verify(bookRepository, times(1)).findAll();
        logger.info("Verified bookRepository.findAll() called once");
    }
}