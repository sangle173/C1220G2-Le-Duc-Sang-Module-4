package com.example.book_borrowing.repositories;

import com.example.book_borrowing.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Category,Integer> {
}
