package com.example.product_management_exercises.reipositories;

import com.example.product_management_exercises.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select  p from Product p where " +
            "concat(p.id, p.name, p.brand, p.madeIn, p.price)" +
            "like %?1%")
    Page<Product> findByNameContaining(String keyword,Pageable pageable);
}
