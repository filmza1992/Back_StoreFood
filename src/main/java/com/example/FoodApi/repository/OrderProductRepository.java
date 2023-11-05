package com.example.FoodApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApi.model.Order;
import com.example.FoodApi.model.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct , Long>{
    List<OrderProduct> findByOrder(Order order);
}
