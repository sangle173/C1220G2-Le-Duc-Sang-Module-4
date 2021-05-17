package com.example.customer_management_web_service.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    T save(T t);

    void remove(Long id);
}
