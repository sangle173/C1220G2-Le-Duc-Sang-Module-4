package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone X", 1000.00, "New", "China"));
        products.put(2, new Product(2, "Iphone XI", 1000.00, "New", "Japan"));
        products.put(3, new Product(3, "Iphone XII", 1000.00, "New", "Japan"));
        products.put(4, new Product(4, "Iphone XIII", 1000.00, "New", "Japan"));
        products.put(5, new Product(5, "Iphone XIV", 1000.00, "New", "Japan"));
        products.put(6, new Product(6, "Iphone XV", 1000.00, "New", "Japan"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    public static void main(String[] args) {
        ProductService p=new ProductService();
        List<Product> productList=p.findAll();
        for (Product o:productList) {
            System.out.println(o);
        }
    }
}
