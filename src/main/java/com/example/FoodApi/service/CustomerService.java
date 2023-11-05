package com.example.FoodApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodApi.model.Customer;
import com.example.FoodApi.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer findById(long id){
        return customerRepository.findById(id);
    }

    public Customer findByCUser(String id){
        return customerRepository.findByCustomerUser(id);
    }

}
