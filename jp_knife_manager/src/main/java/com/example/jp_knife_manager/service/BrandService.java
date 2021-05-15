package com.example.jp_knife_manager.service;

import com.example.jp_knife_manager.model.Brand;
import com.example.jp_knife_manager.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    public List<Brand> findAll() {
        return repository.findAll();
    }

    public void save(Brand brand) {
        repository.save(brand);
    }
}
