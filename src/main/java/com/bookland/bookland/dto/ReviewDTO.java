package com.bookland.bookland.dto;

import com.bookland.bookland.model.Book;
import com.bookland.bookland.model.Review;
import lombok.Getter;

import java.util.List;

@Getter
public class ReviewDTO {

    private Book book;
    private List<Review> reviews;
    public ReviewDTO(List<Review> reviewList) {
        if (reviewList == null || reviewList.isEmpty())
            return ;
        this.book = reviewList.getFirst().getBook();
        for (Review review : reviewList) {
            review.setBook(null);
        }
        reviews = reviewList;
    }

}
