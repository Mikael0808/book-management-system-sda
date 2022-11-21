package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.model.Book;
import com.sda.mihai.bookmanagement.model.Review;
import com.sda.mihai.bookmanagement.repository.BookRepository;
import com.sda.mihai.bookmanagement.repository.BookReviewRepository;
import com.sda.mihai.bookmanagement.service.exceptions.InvalidParameterException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class BookReviewServiceImpl implements BookReviewService {

    private final BookReviewRepository bookReviewRepository;

    private final BookRepository bookRepository;


    public BookReviewServiceImpl(BookReviewRepository bookReviewRepository, BookRepository bookRepository) {
        this.bookReviewRepository = bookReviewRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void create(String bookTitle, int score, String comment) throws InvalidParameterException, EntityNotFoundException {
        if (bookTitle == null || bookTitle.isBlank() || bookTitle.length() < 3) {
            throw new InvalidParameterException("Provide value for bookTitle: " + bookTitle + " is invalid!");
        }
        if (comment == null || comment.isBlank() || comment.length() < 10) {
            throw new InvalidParameterException("Provide value for comment: " + comment + " is invalid!");
        }
        if (score < 1 || score > 5) {
            throw new InvalidParameterException("Provide value for score: " + score + " is invalid!");
        }
        Optional<Book> bookOptional = bookRepository.findByTitle(bookTitle);
        if (bookOptional.isEmpty()) {
            throw new EntityNotFoundException("Book not found for the provided title: " + bookTitle);
        }
        Book book = bookOptional.get();
        Review review = new Review(score, comment);
        review.setBook(book);
    }
}