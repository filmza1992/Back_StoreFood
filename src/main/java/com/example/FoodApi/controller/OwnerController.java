package com.example.FoodApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.FoodApi.business.OwnerBusiness;
import com.example.FoodApi.payload.AddOwnerPayload;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    

    @Autowired
    OwnerBusiness ownerBusiness;

    @PostMapping("/save")
    public ResponseEntity<String> addEmployee(@RequestBody AddOwnerPayload payload) {
        ownerBusiness.addOwner(payload);
        return new ResponseEntity<>("Create Owner username : "+payload.getUsername(),HttpStatus.CREATED);
    }
    
}
