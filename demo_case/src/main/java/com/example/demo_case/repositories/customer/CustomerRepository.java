package com.example.demo_case.repositories.customer;

import com.example.demo_case.model.customer.Customer;
import com.example.demo_case.model.customer.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
    Page<Customer> findByNameContaining(String keyword, Pageable pageable);
    List<Customer> findByNameContaining(String nameSearch);
    List<Customer> findByEmailContaining(String emailSearch);
    List<Customer> findByAddressContaining(String address);
    List<Customer> findByNameContainingAndEmailContaining(String nameSearch, String emailSearch);
}
