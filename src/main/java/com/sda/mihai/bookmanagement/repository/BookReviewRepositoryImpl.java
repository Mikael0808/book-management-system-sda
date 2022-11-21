package com.sda.mihai.bookmanagement.repository;

import com.sda.mihai.bookmanagement.model.Review;

public class BookReviewRepositoryImpl extends BaseRepositoryImpl<Review> implements BookReviewRepository {
    public BookReviewRepositoryImpl() {
        super(Review.class);
    }
}
