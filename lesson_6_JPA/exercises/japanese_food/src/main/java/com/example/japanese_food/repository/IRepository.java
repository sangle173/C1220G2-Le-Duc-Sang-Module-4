package com.example.japanese_food.repository;

import com.example.japanese_food.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends JpaRepository<Product, Integer> {
}
