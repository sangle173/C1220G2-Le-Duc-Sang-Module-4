package com.example.provinces_manager.service;

import com.example.provinces_manager.model.Customer;
import com.example.provinces_manager.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService<Customer> {

    @Autowired
    ICustomerRepository repository;


    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        repository.deleteById(id);
    }
}
