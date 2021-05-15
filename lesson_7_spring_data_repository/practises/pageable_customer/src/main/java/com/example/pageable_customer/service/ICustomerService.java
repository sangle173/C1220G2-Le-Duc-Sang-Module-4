package com.example.pageable_customer.service;

import com.example.pageable_customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);
    Page<Customer> findAllByFirstNameContaining(String name, Pageable pageable);
    Page<Customer> findByOrderByNameDesc(Pageable pageable);
}
