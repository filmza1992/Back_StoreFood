package com.example.FoodApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodApi.model.Order;
import com.example.FoodApi.model.OrderProduct;
import com.example.FoodApi.repository.OrderProductRepository;

@Service
public class OrderProductService {

    @Autowired 
    OrderProductRepository orderProductRepository;
    
    public void save(OrderProduct orderProduct){
        orderProductRepository.save(orderProduct);
    }
    
    public List<OrderProduct> findByOrder(Order order){
        return orderProductRepository.findByOrder(order);
    }

    
}