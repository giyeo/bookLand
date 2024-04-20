package com.bookland.bookland.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private LibraryUser user;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false, length = 1000)
    private String comment;

    @Column(name = "review_date", nullable = false)
    private LocalDateTime reviewDate;

}
