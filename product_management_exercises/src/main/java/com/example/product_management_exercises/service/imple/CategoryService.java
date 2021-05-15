package com.example.product_management_exercises.service.imple;

import com.example.product_management_exercises.model.Category;
import com.example.product_management_exercises.reipositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public void save(Category category) {
        repository.save(category);
    }
}
