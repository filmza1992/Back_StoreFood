package com.example.FoodApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApi.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
    Customer findById(long id);
    Customer findByCustomerUser(String id);
}