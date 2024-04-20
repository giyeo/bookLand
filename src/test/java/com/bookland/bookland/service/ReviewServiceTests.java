package com.bookland.bookland.service;

import com.bookland.bookland.dto.ListReviewDTO;
import com.bookland.bookland.model.LibraryUser;
import com.bookland.bookland.model.Review;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReviewServiceTests {

    @Autowired
    ReviewService reviewService;

    @Test
    public void testGetBookReviewsIsEmpty() {
        ListReviewDTO review = reviewService.getBookReviews(1L);
        Assertions.assertNull(review.getReviews());
    }

    @Test
    public void testAddBookReview() {
        reviewService.addBookReview(1L,1L, null);
        Assertions.assertNull(reviewService.getBookReviews(1L).getReviews());
    }

}
