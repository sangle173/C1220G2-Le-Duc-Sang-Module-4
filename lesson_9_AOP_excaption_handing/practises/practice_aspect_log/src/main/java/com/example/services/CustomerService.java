package com.example.services;

import com.example.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageInfo) throws Exception;

    List<Customer> search(String keyword);

    Page<Customer> search(String keyword, Pageable pageInfo);

    Customer findOne(Integer id);

    Customer save(Customer customer);

    List<Customer> save(List<Customer> customers);

    boolean exists(Integer id);

    List<Customer> findAll(List<Integer> ids);

    long count();

    void delete(Integer id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
