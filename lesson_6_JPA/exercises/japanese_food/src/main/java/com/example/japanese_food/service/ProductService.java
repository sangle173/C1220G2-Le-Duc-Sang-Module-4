package com.example.japanese_food.service;

import com.example.japanese_food.model.Product;
import com.example.japanese_food.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService<Product> {

    @Autowired
    IRepository iRepository;

    @Override
    public List<Product> findAll() {
        return iRepository.findAll();
    }
}
