package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.service.exceptions.InvalidParameterException;

public interface AuthorService {
    void createAuthor(String firstName, String lastName) throws InvalidParameterException;
}
