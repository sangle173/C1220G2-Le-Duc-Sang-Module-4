package com.example.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    private Map<Product, Integer> products;

    public Cart() {
        products = new HashMap<>();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public void addToCart(Product product) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    public void changeQuantity(Product product, int quantity) {
        products.replace(product, quantity);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getSize() {
        return products.size();
    }

    public int getTotalAmount() {
        int total = 0;
        Set<Product> productSet = products.keySet();
        for (Product product : productSet) {
            total += product.getPrice() * products.get(product);
        }
        return total;
    }
}
