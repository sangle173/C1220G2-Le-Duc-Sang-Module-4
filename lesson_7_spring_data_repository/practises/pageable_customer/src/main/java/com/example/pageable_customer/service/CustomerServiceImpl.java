package com.example.pageable_customer.service;

import com.example.pageable_customer.model.Customer;
import com.example.pageable_customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    ICustomerRepository repository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }
}
