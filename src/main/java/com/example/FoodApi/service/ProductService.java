package com.example.FoodApi.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodApi.model.Product;
import com.example.FoodApi.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productsRepository;

    public Product save(Product product){
        
        return productsRepository.save(product);
    }

    public Product findById(long id){
        return productsRepository.findById(id);
    }

    public List<Product> findAll(){
        return productsRepository.findAll();
    }
}