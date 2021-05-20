package com.example.product_management_exercises.service;

import org.springframework.data.domain.Page;


public interface IProductService<E>{
    Page<E> findAll(int pageNum,String sortField, String sortDir, String keyword);

    void save(E e);

    E findById(Long id);

    void deleteById(Long id);
}
