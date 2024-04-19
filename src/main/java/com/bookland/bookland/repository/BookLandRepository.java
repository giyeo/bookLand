package com.bookland.bookland.repository;

import com.bookland.bookland.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLandRepository extends JpaRepository<Book, Long> {

}
