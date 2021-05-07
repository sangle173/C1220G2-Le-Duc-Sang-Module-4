package com.example.blog.service;

import java.util.List;

public interface IBlogService<E> {

    List<E> findAll();

    E findById(Integer id);

    void save(E e);

    void delete(Integer id);

    void update(E e);

}
