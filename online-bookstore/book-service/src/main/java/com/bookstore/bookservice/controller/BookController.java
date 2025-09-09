package com.bookstore.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService service;

	@GetMapping
	public List<Book> getAll() {
		return service.getAllBooks();
	}

	@PostMapping
	public Book add(@RequestBody Book book) {
		System.out.println("Received book: " + book); // Add this line
		return service.addBook(book);
	}
}
