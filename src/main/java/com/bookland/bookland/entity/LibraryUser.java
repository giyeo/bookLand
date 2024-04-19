package com.bookland.bookland.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LibraryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String fullName;
}

