package com.example.pageable_customer.repository;

import com.example.pageable_customer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
   Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
