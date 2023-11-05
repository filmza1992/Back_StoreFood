package com.example.FoodApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodApi.model.Owner;
import com.example.FoodApi.repository.OwnerRepository;

@Service
public class OwnerService {
    
    @Autowired
    OwnerRepository ownerRepository;

    public void save(Owner owner){
        ownerRepository.save(owner);
    }
}
