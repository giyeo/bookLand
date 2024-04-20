package com.bookland.bookland.controller;

import com.bookland.bookland.dto.ListReviewDTO;
import com.bookland.bookland.model.Book;
import com.bookland.bookland.model.Review;
import com.bookland.bookland.service.BookService;
import com.bookland.bookland.service.ReservationService;
import com.bookland.bookland.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookLandController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/available")
    public List<Book> getAllAvailableBooks() {
        return bookService.getAllAvailableBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/{id}/reserve/{user_id}")
    public void reserveBook(@PathVariable Long id,
                            @PathVariable Long user_id) {
        reservationService.reserveBook(id, user_id);
    }

    @GetMapping("/{id}/reviews")
    public ListReviewDTO getBookReviews(@PathVariable Long id) {
        return reviewService.getBookReviews(id);
    }

    @PostMapping("/{id}/reviews/{user_id}")
    public void addBookReview(@PathVariable Long id,
                              @PathVariable Long user_id,
                              @RequestBody Review review) {
        reviewService.addBookReview(id, user_id, review);
    }
}
