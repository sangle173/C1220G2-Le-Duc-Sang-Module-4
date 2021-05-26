package com.example.demo_case.repositories.service_hotel;

import com.example.demo_case.model.service_hotel.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
    Page<ServiceType> findByNameContaining(String keyword, Pageable pageable);
}
