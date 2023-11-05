package com.example.FoodApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.FoodApi.business.CustomerBusiness;
import com.example.FoodApi.exception.CustomerException;
import com.example.FoodApi.payload.AddCustomerPayload;
import com.example.FoodApi.payload.VerifyPayload;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    
    @Autowired
    CustomerBusiness customerBusiness;

    @PostMapping("/save")
    public ResponseEntity<String> addCustomer(@RequestBody AddCustomerPayload payload) {
        customerBusiness.insert(payload);
          return new ResponseEntity<>("Create Customer "+payload.getFirstName() + " and User : "+payload.getCustomerUser(),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable("id") long id , @RequestBody AddCustomerPayload payload) {
        customerBusiness.updateCustomer(id , payload);
        return new ResponseEntity<>("Create Customer "+payload.getFirstName() + " and User : "+payload.getCustomerUser(),HttpStatus.CREATED);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyCustomer(@RequestBody VerifyPayload payload){
        try {
            System.out.println(payload.getId());
            System.out.println(payload.getPassword());
            customerBusiness.findUser(payload);
            return new ResponseEntity<>("User verified", HttpStatus.OK);
        } catch (CustomerException ex) {
            return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
        }
    }
}
