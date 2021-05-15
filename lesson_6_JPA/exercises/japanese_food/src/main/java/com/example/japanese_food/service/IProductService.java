package com.example.japanese_food.service;


import java.util.List;

public interface IProductService<E> {
    List<E> findAll();
}
