package com.example.services;

import com.example.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);
}
