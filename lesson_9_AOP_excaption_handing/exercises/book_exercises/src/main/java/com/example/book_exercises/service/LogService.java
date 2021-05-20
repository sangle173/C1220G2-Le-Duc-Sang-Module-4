package com.example.book_exercises.service;

public interface LogService {
    long getSize();

    void initialize();

    int getVisitorNumber(Integer id);

    void addVisitor(Integer id);
}
