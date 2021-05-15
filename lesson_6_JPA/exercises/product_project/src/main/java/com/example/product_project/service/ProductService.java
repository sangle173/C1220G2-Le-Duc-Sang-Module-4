package com.example.product_project.service;

import com.example.product_project.model.Product;
import com.example.product_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService<Product> {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
