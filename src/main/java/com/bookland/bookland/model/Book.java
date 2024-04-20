package com.bookland.bookland.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(name = "publication_year", nullable = false)
    private int publicationYear;

    @Column(nullable = false)
    private boolean availability;
}
