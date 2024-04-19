package com.bookland.bookland.controller;

import com.bookland.bookland.entity.Book;
import com.bookland.bookland.entity.Review;
import com.bookland.bookland.service.BookLandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookLandController {
    @Autowired
    private BookLandService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/{id}/reserve")
    public void reserveBook(@PathVariable Long id) {
        bookService.reserveBook(id);
    }

    @GetMapping("/{id}/reviews")
    public List<Review> getBookReviews(@PathVariable Long id) {
        return bookService.getBookReviews(id);
    }

    @PostMapping("/{id}/reviews")
    public void addBookReview(@PathVariable Long id, @RequestBody Review review) {
        bookService.addBookReview(id, review);
    }
}
