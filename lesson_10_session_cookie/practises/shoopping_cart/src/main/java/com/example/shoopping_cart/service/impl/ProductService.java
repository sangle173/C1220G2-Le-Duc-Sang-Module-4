package com.example.shoopping_cart.service.impl;

import com.example.shoopping_cart.model.Product;
import com.example.shoopping_cart.repository.IProductRepository;
import com.example.shoopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}
