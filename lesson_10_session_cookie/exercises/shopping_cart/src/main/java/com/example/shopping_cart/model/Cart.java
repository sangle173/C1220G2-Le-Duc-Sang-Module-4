package com.example.shopping_cart.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    private Map<Product, Long> products;

    public Cart() {
        products = new HashMap<>();
    }

    public Map<Product, Long> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Long> products) {
        this.products = products;
    }

    public void addToCart(Product product) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, (long) 1);
        }
    }

    public void changeQuantity(Product product, Long quantity) {
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
