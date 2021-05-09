package com.example.provinces_manager.service;

import com.example.provinces_manager.model.Province;
import com.example.provinces_manager.repository.IProvincesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService implements IProvinceService<Province> {
    @Autowired
    IProvincesRepository repository;

    @Override
    public List<Province> findAll() {
        return repository.findAll();
    }

    @Override
    public Province findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        repository.save(province);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
