package com.bookland.bookland.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @NonNull
    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @NonNull
    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;

    @NonNull
    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

}

