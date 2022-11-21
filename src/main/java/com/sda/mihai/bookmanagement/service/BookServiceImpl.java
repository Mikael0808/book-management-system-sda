package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.model.Author;
import com.sda.mihai.bookmanagement.model.Book;
import com.sda.mihai.bookmanagement.repository.AuthorRepository;
import com.sda.mihai.bookmanagement.repository.BookRepository;
import com.sda.mihai.bookmanagement.service.exceptions.InvalidParameterException;

import javax.persistence.EntityNotFoundException;

import java.util.Optional;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void createBook(String title, String description, int authorId) throws InvalidParameterException {
        if (title == null || title.isBlank() || title.length() < 3) {
            throw new InvalidParameterException("Provide value for title: " + title + "is invalid!");
        }
        if (description == null || title.isBlank() || title.length() < 10) {
            throw new InvalidParameterException("Provide value for description: " + description + "is invalid!");
        }
        if (authorId < 1) {
            throw new InvalidParameterException("Provide value for authorId: " + authorId + " is invalid!");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with provided id: " + authorId + " was not found");
        }
        Author author = authorOptional.get();
        Book book = new Book(title, description);
        book.setAuthor(author);
        bookRepository.create(book);
    }
}

