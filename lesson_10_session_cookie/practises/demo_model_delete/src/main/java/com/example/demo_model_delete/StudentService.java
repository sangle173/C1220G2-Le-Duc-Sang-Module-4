package com.example.demo_model_delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public List<Student> findAll() {
        return repo.findAll();
    }

    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public Student findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Student student) {
        repo.save(student);
    }
}
