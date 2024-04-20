package com.bookland.bookland.repository;

import com.bookland.bookland.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findTopByBookIdOrderByReturnDateDesc(Long bookId);
}
