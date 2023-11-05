package com.example.FoodApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApi.model.Product;

public interface ProductRepository extends JpaRepository<Product , Long>{
    Product findById(long id);
    List<Product> findAll();
}
