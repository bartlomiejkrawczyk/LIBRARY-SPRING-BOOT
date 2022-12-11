package com.example.library.controller;

import com.example.library.entity.Book;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("book")
@RestController
public class BookController {

	private final BookService bookService;

	@GetMapping("/{isbn}")
	public Book getBookByIsbn(@PathVariable String isbn) {
		return bookService.getBookById(isbn).orElse(null);
	}

	@GetMapping("/available")
	public Iterable<Book> getAvailableBooks() {
		return bookService.getAvailableBooks();
	}

	@GetMapping({"/", ""})
	public Iterable<Book> getBooks() {
		return bookService.getBooks();
	}

	@PostMapping({"/", ""})
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
}
