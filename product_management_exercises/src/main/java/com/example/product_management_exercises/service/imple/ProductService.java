package com.example.product_management_exercises.service.imple;

import com.example.product_management_exercises.model.Product;
import com.example.product_management_exercises.reipositories.ProductRepository;
import com.example.product_management_exercises.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements IProductService<Product> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(int pageNum, String sortField, String sortDir, String keyword) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        if (keyword != null) {
            return productRepository.findByNameContaining(keyword, pageable);
        }
        return productRepository.findAll(pageable);
    }

    public List<Product> findByNameCategoryBrand(String name, String categoryName, String brand) {
        if (name==null&&categoryName==null&&brand==null){
            return productRepository.findAll();
        }
        return productRepository.findByNameContainingAndCategory_NameContainingAndBrandContaining(name, categoryName, brand);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
