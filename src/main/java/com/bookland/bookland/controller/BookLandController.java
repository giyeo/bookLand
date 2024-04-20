package com.bookland.bookland.controller;

import com.bookland.bookland.dto.ReviewDTO;
import com.bookland.bookland.model.Book;
import com.bookland.bookland.model.Review;
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
    public ReviewDTO getBookReviews(@PathVariable Long id) {
        return new ReviewDTO(bookService.getBookReviews(id));
    }

    @PostMapping("/{id}/reviews/{user_id}")
    public void addBookReview(@PathVariable Long id,
                              @PathVariable Long user_id,
                              @RequestBody Review review) {
        bookService.addBookReview(id, user_id, review);
    }
}
