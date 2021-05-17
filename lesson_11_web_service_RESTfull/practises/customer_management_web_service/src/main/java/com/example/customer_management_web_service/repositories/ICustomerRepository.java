package com.example.customer_management_web_service.repositories;

import com.example.customer_management_web_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
