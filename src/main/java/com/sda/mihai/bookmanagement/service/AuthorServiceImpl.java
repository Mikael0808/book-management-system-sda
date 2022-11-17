package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.model.Author;
import com.sda.mihai.bookmanagement.repository.AuthorRepository;
import com.sda.mihai.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.mihai.bookmanagement.service.exceptions.InvalidParameterException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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

    @Override
    public void updateAuthor(int authorId, String firstName, String lastName) throws InvalidParameterException {
        if (authorId < 1) {
            throw new InvalidParameterException("Provide value for authorId: " + authorId + " is invalid!");
        }
        if (firstName == null || firstName.isBlank() || firstName.length() < 3) {
            throw new InvalidParameterException("Provide value for first name: " + firstName + " is invalid!");
        }
        if (firstName == null || lastName.isBlank() || lastName.length() < 3) {
            throw new InvalidParameterException("Provide value for last name: " + lastName + " is invalid!");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with id: " + authorId + " was not found!");
        }
        Author author = authorOptional.get();
        author.setFirstname(firstName);
        author.setLastname(lastName);
        authorRepository.update(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findALl();
    }

}