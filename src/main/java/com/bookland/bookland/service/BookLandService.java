package com.bookland.bookland.service;

import com.bookland.bookland.model.Book;
import com.bookland.bookland.model.LibraryUser;
import com.bookland.bookland.model.Review;
import com.bookland.bookland.repository.BookRepository;
import com.bookland.bookland.repository.LibraryUserRepository;
import com.bookland.bookland.repository.ReviewRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class BookLandService {

    private static final Logger logger = LogManager.getLogger(BookLandService.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private LibraryUserRepository libraryUserRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    private LibraryUser getLibraryUser(Long id) { return libraryUserRepository.findById(id).orElse(null); }

    public void reserveBook(Long id) {
        // maybe just mark a time gap
    }

    public List<Review> getBookReviews(Long id) {
        return reviewRepository.findByBookId(id);
    }

    public void addBookReview(Long bookID, Long userID, Review review) {

        Book book = getBookById(bookID);
        if (book == null) {
            logger.error("Book not found with ID: {}", bookID);
            return ;
        }
        review.setBook(book);

        LibraryUser user = getLibraryUser(userID);
        if (user == null) {
            logger.error("User not found with ID: {}", userID);
            return;
        }
        review.setUser(getLibraryUser(userID));

        logger.info("Saving review to repository: {}", review.getBook().getId());
        reviewRepository.save(review);
    }
}
