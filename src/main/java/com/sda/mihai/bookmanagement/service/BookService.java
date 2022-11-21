package com.sda.mihai.bookmanagement.service;

import com.sda.mihai.bookmanagement.model.Author;
import com.sda.mihai.bookmanagement.model.Book;
import com.sda.mihai.bookmanagement.service.exceptions.InvalidParameterException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface BookService {
    void createBook(String title, String description, int authorId) throws EntityNotFoundException, InvalidParameterException;

    List<Book> getAllBooks();
}