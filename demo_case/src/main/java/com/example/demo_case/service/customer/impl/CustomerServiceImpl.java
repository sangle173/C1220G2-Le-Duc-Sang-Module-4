package com.example.demo_case.service.customer.impl;

import com.example.demo_case.model.customer.Customer;
import com.example.demo_case.repositories.customer.CustomerRepository;
import com.example.demo_case.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;
    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
