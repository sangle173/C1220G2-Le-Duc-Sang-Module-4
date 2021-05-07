package com.example.student_management.service;

import com.example.student_management.model.Student;

import java.util.List;


public interface StudentService {

    List<Student> findAll();

    Student findById(Integer id);

    void save(Student student);

    void deleteById(Integer id);
}
