package com.bookland.bookland.dto;

import com.bookland.bookland.model.Book;
import com.bookland.bookland.model.Review;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ListReviewDTO {

    private Book book;
    private List<ReviewDTO> reviews;

    public ListReviewDTO(Book book, List<Review> reviewList) {
        if (book == null || reviewList == null || reviewList.isEmpty())
            return;
        this.book = book;
        reviews = reviewList.stream()
                .map(ReviewDTO::new)
                .collect(Collectors.toList());
    }
}