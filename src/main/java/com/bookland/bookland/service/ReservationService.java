package com.bookland.bookland.service;

import com.bookland.bookland.model.Reservation;
import com.bookland.bookland.repository.ReservationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {

    private static final Logger logger = LogManager.getLogger(ReservationService.class);

    @Autowired
    ReservationRepository reservationRepository;

    @CacheEvict(value = "isBookAvailableCache", key = "#id")
    public void reserveBook(Long id, Long userId) {
        if(!isBookAvailable(id))
            return;

        LocalDate current = LocalDate.now();
        LocalDate nextWeek = current.plusWeeks(1);
        Reservation reservation = new Reservation(userId, id, current, nextWeek);
        logger.info("Reserving book: {} for the user: {}", id, userId);
        reservationRepository.save(reservation);
    }

    @Cacheable(value = "isBookAvailableCache", key = "#id")
    public Boolean isBookAvailable(Long id) {
        Optional<Reservation> lastReservationOpt = reservationRepository.findTopByBookIdOrderByReturnDateDesc(id);

        if (lastReservationOpt.isPresent()) {
            Reservation lastReservation = lastReservationOpt.get();
            LocalDate now = LocalDate.now();

            return now.isAfter(lastReservation.getReturnDate());
        } else {
            return true;
        }
    }

}
