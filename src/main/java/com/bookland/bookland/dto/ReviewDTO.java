package com.bookland.bookland.dto;

import com.bookland.bookland.model.Book;
import com.bookland.bookland.model.Review;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ReviewDTO {

    private LocalDateTime reviewDate;
    private String username;
    private int rating;
    private String comment;

    public ReviewDTO(Review review) {
        if (review == null)
            return ;

        this.reviewDate = review.getReviewDate();
        this.username = review.getUser().getUsername();
        this.rating = review.getRating();
        this.comment = review.getComment();
    }

}
