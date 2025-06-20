package com.expertise.bookstore.testing.example.service;

import com.expertise.bookstore.testing.example.repository.BookRepository;
import com.expertise.bookstore.testing.example.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteBookTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testDeleteBook_BookExists() {
        Long bookId = 1L;
        when(bookRepository.existsById(bookId)).thenReturn(true);
        doNothing().when(bookRepository).deleteById(bookId);

        bookService.deleteBook(bookId);

        verify(bookRepository, times(1)).existsById(bookId);
        verify(bookRepository, times(1)).deleteById(bookId);
    }

    @Test
    void testDeleteBook_BookNotFound() {
        Long bookId = 2L;
        when(bookRepository.existsById(bookId)).thenReturn(false);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            bookService.deleteBook(bookId);
        });

        assertEquals("Book not found with id: 2", ex.getMessage());
        verify(bookRepository, times(1)).existsById(bookId);
        verify(bookRepository, never()).deleteById(bookId);
    }
}
