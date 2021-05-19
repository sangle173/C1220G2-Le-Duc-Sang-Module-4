package com.example.phone_manager.service.impl;

import com.example.phone_manager.model.Phone;
import com.example.phone_manager.repositories.IPhoneRepository;
import com.example.phone_manager.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService implements IPhoneService {
    @Autowired
    private IPhoneRepository repository;

    @Override
    public List<Phone> findAll() {
        return repository.findAll();
    }

    @Override
    public Phone findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Phone save(Phone phone) {
        return repository.save(phone);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
