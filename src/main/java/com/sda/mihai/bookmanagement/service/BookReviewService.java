package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.service.exceptions.InvalidParameterException;

public interface BookReviewService {
    void create(String bookTitle, int score, String comment) throws InvalidParameterException;
}
