package com.example.FoodApi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApi.model.Order;

public interface OrderRepository extends JpaRepository<Order , Long>{
    Order findById(long id);
    
    List<Order> findAll();

    
    
} 

