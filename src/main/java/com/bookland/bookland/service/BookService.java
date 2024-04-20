package com.bookland.bookland.service;

import com.bookland.bookland.model.Book;
import com.bookland.bookland.repository.BookRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static final Logger logger = LogManager.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReservationService reservationService;

    @Cacheable("getAllBooksCache")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAllAvailableBooks() {
        return bookRepository.findAll().stream()
                .filter(book -> reservationService.isBookAvailable(book.getId()))
                .collect(Collectors.toList());
    }

    @Cacheable("getBookByIdCache")
    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            logger.error("Book not found with ID: {}", id);
            return null;
        }
        return book;
    }

}
