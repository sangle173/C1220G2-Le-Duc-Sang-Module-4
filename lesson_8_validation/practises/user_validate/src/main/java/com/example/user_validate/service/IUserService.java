package com.example.user_validate.service;

import java.util.List;

public interface IUserService<E> {
    List<E> findAll();

    E findById(Integer id);

    void save(E e);
}
