package com.example.demo_case.service;

import java.util.List;

public interface IGeneralService<E> {

    List<E> findAll();

    E findById(Integer id);

    E save(E e);

    void deleteById(Integer id);
}
