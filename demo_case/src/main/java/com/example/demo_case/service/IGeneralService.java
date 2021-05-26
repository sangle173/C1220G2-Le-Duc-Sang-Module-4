package com.example.demo_case.service;

import com.example.demo_case.model.customer.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IGeneralService<E> {
    static final int ENTRIES_PER_PAGE = 5;

    List<E> findAll();

    E findById(Integer id);

    E save(E e);

    void deleteById(Integer id);
}
