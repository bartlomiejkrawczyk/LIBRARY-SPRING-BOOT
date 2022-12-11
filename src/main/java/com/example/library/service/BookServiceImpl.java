package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	@Override
	public Optional<Book> getBookById(String isbn) {
		return bookRepository.findById(isbn);
	}

	@Override
	public Iterable<Book> getAvailableBooks() {
		return bookRepository.findAvailableBooks();
	}

	@Override
	public Iterable<Book> getBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
}
