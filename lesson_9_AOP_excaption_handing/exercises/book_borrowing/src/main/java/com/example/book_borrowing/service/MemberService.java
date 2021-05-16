package com.example.book_borrowing.service;

import com.example.book_borrowing.model.Category;
import com.example.book_borrowing.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Category> findAll() {
        return bookRepository.findAll();
    }
}
