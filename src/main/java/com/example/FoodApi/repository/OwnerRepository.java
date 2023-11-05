package com.example.FoodApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodApi.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner , Long>{
    
}   
