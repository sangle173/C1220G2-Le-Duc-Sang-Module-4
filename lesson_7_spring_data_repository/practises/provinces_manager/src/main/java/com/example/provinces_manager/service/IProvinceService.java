package com.example.provinces_manager.service;


import java.util.List;

public interface IProvinceService<E> {
    List<E> findAll();

    E findById(Integer id);

    void save(E e);

    void remove(Integer id);
}
