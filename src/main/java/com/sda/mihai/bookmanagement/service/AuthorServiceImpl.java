package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.model.Author;
import com.sda.mihai.bookmanagement.repository.AuthorRepository;
import com.sda.mihai.bookmanagement.service.exceptions.InvalidParameterException;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(String firstName, String lastName) throws InvalidParameterException {
        if (firstName == null || firstName.isBlank() || firstName.length() < 3) {
            throw new InvalidParameterException("Provide value for first name: " + firstName + "is invalid!");
        }
        if (firstName == null || lastName.isBlank() || lastName.length() < 3) {
            throw new InvalidParameterException("Provide value for last name: " + lastName + "is invalid!");
        }

        authorRepository.create(new Author(firstName, lastName));
    }

}