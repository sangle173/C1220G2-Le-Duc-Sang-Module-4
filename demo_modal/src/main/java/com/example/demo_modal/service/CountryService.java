package com.example.demo_modal.service;

import com.example.demo_modal.model.Country;
import com.example.demo_modal.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public Page<Country> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Country findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Country country) {
        repository.save(country);
    }

    public void deleteBYId(Integer id) {
        repository.deleteById(id);
    }

}
