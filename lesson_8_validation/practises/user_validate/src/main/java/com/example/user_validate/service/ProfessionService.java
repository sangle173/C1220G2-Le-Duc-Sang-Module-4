package com.example.user_validate.service;

import com.example.user_validate.model.Profession;
import com.example.user_validate.repository.IProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionService implements IProfessionService<Profession>{
    @Autowired
    private IProfessionRepository repository;
    @Override
    public List<Profession> findAll() {
        return repository.findAll();
    }
}
