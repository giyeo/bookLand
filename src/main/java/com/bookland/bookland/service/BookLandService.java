package com.bookland.bookland.service;

import com.bookland.bookland.entity.Book;
import com.bookland.bookland.entity.Review;
import com.bookland.bookland.repository.BookLandRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class BookLandService {
    @Autowired
    private BookLandRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void reserveBook(Long id) {
        // maybe just mark a time gap
    }

    public List<Review> getBookReviews(Long id) {
        // get that review from given book
        return null;
    }

    public void addBookReview(Long id, Review review) {
        // add review to database
    }
}
