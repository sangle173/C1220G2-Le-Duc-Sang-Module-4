package com.example.book_exercises.repository;


import com.example.book_exercises.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
	List<Borrow> findByBorrowerId(long borrowerId);
	List<Borrow> findByBookId(long bookId);
}
