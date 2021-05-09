package com.example.blog.service;

import java.util.List;

public interface ICategoryService<E>{
    List<E> findAll();

    E findById(Integer id);

    void save(E e);

    void remove(Integer id);
}
