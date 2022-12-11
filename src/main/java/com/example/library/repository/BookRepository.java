package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {

	@Query("SELECT b FROM Book b INNER JOIN Issue i ON b.isbn = i.isbn WHERE i.userId IS NULL")
	Iterable<Book> findAvailableBooks();
}
