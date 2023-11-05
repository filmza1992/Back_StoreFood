package com.example.FoodApi.business;

import org.springframework.stereotype.Service;

import com.example.FoodApi.exception.CustomerException;
import com.example.FoodApi.model.Customer;
import com.example.FoodApi.payload.AddCustomerPayload;
import com.example.FoodApi.payload.VerifyPayload;
import com.example.FoodApi.service.CustomerService;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;



@Service
public class CustomerBusiness {
    @Autowired
    CustomerService customerService;

    public void insert(AddCustomerPayload payload){
        Customer customer = new Customer();
        customer.setFirstName(payload.getFirstName());
        customer.setLastName(payload.getLastName());
        customer.setCustomerUser(payload.getCustomerUser());
        customer.setPassword(payload.getPassword());
        customer.setCreatedAt(LocalDateTime.now());
        
        customerService.save(customer);
    }  

    public void updateCustomer(long id , AddCustomerPayload payload){
        Customer customer = customerService.findById(id);
        customer.setFirstName(payload.getFirstName());
        customer.setLastName(payload.getLastName());
        customer.setCustomerUser(payload.getCustomerUser());
        customer.setPassword(payload.getPassword());

        customerService.save(customer);
    }

    public void findUser(VerifyPayload payload){
        Customer customer = customerService.findByCUser(payload.getId());
        if(customer == null){
            throw new CustomerException();
            
        }
        if(!payload.getPassword().equals(customer.getPassword())){
            throw new CustomerException();
        }
        
    }

    
}
