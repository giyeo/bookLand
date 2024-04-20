package com.bookland.bookland.service;

import com.bookland.bookland.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTests {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetAllBooks() {
        List<Book> books = bookService.getAllBooks();
        Assertions.assertNotNull(books);
        Assertions.assertEquals(3, books.size());
    }

    @Test
    public void testGetAllAvailableBooks() {
        List<Book> books = bookService.getAllAvailableBooks();
        Assertions.assertNotNull(books);
        Assertions.assertEquals(3, books.size());
    }

    @Test
    public void testGetBookByIdIsNonNull() {
        Book book = bookService.getBookById(1L);
        Assertions.assertNotNull(book);
    }

    @Test
    public void testGetBookByIdIsNull() {
        Book book = bookService.getBookById(0L);
        Assertions.assertNull(book);
    }

}
