package com.example.phone_manager.service;

import com.example.phone_manager.model.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> findAll();
    Phone findById(Long id);
    Phone save(Phone phone);

    void remove(Long id);
}
