package com.bookland.bookland.service;

import com.bookland.bookland.dto.ListReviewDTO;
import com.bookland.bookland.model.Book;
import com.bookland.bookland.model.LibraryUser;
import com.bookland.bookland.model.Review;
import com.bookland.bookland.repository.ReviewRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private static final Logger logger = LogManager.getLogger(ReviewService.class);

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private LibraryUserService libraryUserService;

    @Cacheable(value = "getBookReviewsCache", key = "#id")
    public ListReviewDTO getBookReviews(Long id) {
        List<Review> reviews = reviewRepository.findByBookId(id);
        Book book = bookService.getBookById(id);
        if (book == null) {
            return null;
        }
        return new ListReviewDTO(book, reviews);
    }

    @CacheEvict(value = "getBookReviewsCache", key = "#id")
    public void addBookReview(Long id, Long userID, Review review) {

        if (review == null)
            return ;

        Book book = bookService.getBookById(id);
        if (book == null) {
            return ;
        }
        review.setBookId(id);

        LibraryUser user = libraryUserService.getLibraryUser(userID);
        if (user == null) {
            logger.error("User not found with ID: {}", userID);
            return;
        }
        review.setUser(user);

        logger.info("Saving review of book: {}, from user: {}, to repository.", review.getBookId(), user.getId());
        reviewRepository.save(review);
    }
}
