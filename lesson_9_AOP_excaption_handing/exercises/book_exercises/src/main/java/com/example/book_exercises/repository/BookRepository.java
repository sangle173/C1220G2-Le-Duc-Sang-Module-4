package com.example.book_exercises.repository;


import com.example.book_exercises.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByAuthorName(String authorName);
}
