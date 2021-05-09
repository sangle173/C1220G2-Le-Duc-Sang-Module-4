package com.example.provinces_manager.repository;

import com.example.provinces_manager.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvincesRepository extends JpaRepository<Province, Integer> {
}
