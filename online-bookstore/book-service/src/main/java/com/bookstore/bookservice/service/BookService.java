package com.bookstore.bookservice.service;

import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book addBook(Book book) {
        return repo.save(book);
    }
}