package com.example.product_management_bonus.service;

import com.example.product_management_bonus.model.Product;
import com.example.product_management_bonus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public void save(Product product) {
        repository.save(product);
    }

    public Product findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
