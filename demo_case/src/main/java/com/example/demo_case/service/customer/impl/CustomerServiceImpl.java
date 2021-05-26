package com.example.demo_case.service.customer.impl;

import com.example.demo_case.model.customer.Customer;
import com.example.demo_case.repositories.customer.CustomerRepository;
import com.example.demo_case.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    public static final int ENTRIES_PER_PAGE = 5;

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Autowired
    private CustomerRepository repository;

    @Override
    public Page<Customer> findAll(int pageNum, String sortField, String sortDir, String keyword) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        if (keyword != null) {
            return repository.findByNameContaining(keyword, pageable);
        }
        return repository.findAll(pageable);
    }

    @Override
    public List<Customer> findByField(String nameSearch, String emailSearch) {
        if (nameSearch==null&&emailSearch==null){
            return repository.findAll();
        }
        return repository.findByNameContainingAndEmailContaining(nameSearch, emailSearch);
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
