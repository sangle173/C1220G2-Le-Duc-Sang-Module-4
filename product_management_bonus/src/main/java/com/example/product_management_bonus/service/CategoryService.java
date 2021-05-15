package com.example.product_management_bonus.service;

import com.example.product_management_bonus.model.Category;
import com.example.product_management_bonus.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public void save(Category category){
        repository.save(category);
    }
}
