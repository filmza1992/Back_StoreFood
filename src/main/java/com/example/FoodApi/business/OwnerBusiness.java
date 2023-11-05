package com.example.FoodApi.business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodApi.model.Owner;
import com.example.FoodApi.payload.AddOwnerPayload;
import com.example.FoodApi.service.OwnerService;

@Service
public class OwnerBusiness {
    @Autowired
    OwnerService ownerService;

    public void addOwner(AddOwnerPayload addOwnerPayload){
        Owner owner = new Owner();
        LocalDate birthDay = LocalDate.parse(addOwnerPayload.getBirthDay(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        owner.setUsername(addOwnerPayload.getUsername());
        owner.setEmail(addOwnerPayload.getEmail());
        owner.setPassword(addOwnerPayload.getPassword());
        owner.setBirthDay(birthDay);
        ownerService.save(owner);
    }  

    
}
