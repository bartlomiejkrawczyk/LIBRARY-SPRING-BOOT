package com.example.library.service;

import com.example.library.entity.Book;
import java.util.Optional;

public interface BookService {

	Optional<Book> getBookById(String isbn);

	Iterable<Book> getAvailableBooks();

	Iterable<Book> getBooks();

	Book saveBook(Book book);
}
