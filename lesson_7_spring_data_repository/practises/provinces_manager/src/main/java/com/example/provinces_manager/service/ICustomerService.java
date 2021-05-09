package com.example.provinces_manager.service;

import com.example.provinces_manager.model.Customer;

import java.util.List;

public interface ICustomerService<E>{
    List<E> findAll();

    E findById(Integer id);

    void save(E e);

    void remove(Integer id);
}
