package com.expertise.bookstore.testing.example.service;

import com.expertise.bookstore.testing.example.model.Book;
import com.expertise.bookstore.testing.example.repository.BookRepository;
import com.expertise.bookstore.testing.example.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateBookTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testUpdateBook_BookExists() {
        Long bookId = 1L;
        Book existingBook = new Book(bookId, "Old Title", "Old Author");
        Book updatedBook = new Book(null, "New Title", "New Author");

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(any(Book.class))).thenAnswer(inv -> inv.getArgument(0));

        Book result = bookService.updateBook(bookId, updatedBook);

        assertEquals("New Title", result.getTitle());
        assertEquals("New Author", result.getAuthor());
        verify(bookRepository, times(1)).save(existingBook);
    }

    @Test
    void testUpdateBook_BookNotFound() {
        Long bookId = 2L;
        Book updatedBook = new Book(null, "Doesn't Matter", "Someone");

        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            bookService.updateBook(bookId, updatedBook);
        });

        assertEquals("Book not found with id: 2", ex.getMessage());
        verify(bookRepository, never()).save(any());
    }
}
