package com.example.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICategoryService<E>{
    Page<E> findAll(Pageable pageable);

    E findById(Integer id);

    void save(E e);

    void remove(Integer id);
}
