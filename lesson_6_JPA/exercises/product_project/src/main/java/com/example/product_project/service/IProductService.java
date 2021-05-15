package com.example.product_project.service;

import java.util.List;

public interface IProductService<E> {

    List<E> findAll();

    E findById(Integer id);

    void save(E e);

    void delete(Integer id);

}
