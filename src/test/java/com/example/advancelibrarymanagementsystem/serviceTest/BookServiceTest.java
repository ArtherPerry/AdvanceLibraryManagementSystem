package com.example.advancelibrarymanagementsystem.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.advancelibrarymanagementsystem.entitites.Book;
import com.example.advancelibrarymanagementsystem.repo.BookRepository;
import com.example.advancelibrarymanagementsystem.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveBook() {
        Book book = new Book();
        book.setTitle("Test Book");
        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.saveBook(book);
        assertEquals("Test Book", result.getTitle());
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testUpdateBook() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Updated Book");
        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.updateBook(1L, book);
        assertEquals("Updated Book", result.getTitle());
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    void testDeleteBook() {
        doNothing().when(bookRepository).deleteById(1L);
        bookService.deleteBook(1L);
        verify(bookRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindBookById() {
        Book book = new Book();
        book.setId(1L);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Book> result = bookService.findBookById(1L);
        assertEquals(1L, result.get().getId());
    }

    @Test
    void testFindAllBooks() {
        bookService.findAllBooks();
        verify(bookRepository, times(1)).findAll();
    }
}