package com.example.FoodApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.FoodApi.business.OrderBusiness;
import com.example.FoodApi.json.OrderJson;
import com.example.FoodApi.payload.AddOrderPayload;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    OrderBusiness orderBusiness;

    @GetMapping("/")
    public ResponseEntity<List<OrderJson>> getOrder() {
       return ResponseEntity.ok(orderBusiness.getAll());
    }
    @PostMapping("/save")
    public ResponseEntity<String> addOrder(@RequestBody AddOrderPayload payload) {
        orderBusiness.insert(payload);
        return new ResponseEntity<>("Create Order customer : "+payload.getCustomerId(),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable("id") long id , @RequestBody AddOrderPayload payload){
        orderBusiness.updateOrder(id, payload);
        return new ResponseEntity<>("Update Success Order"+Long.toString(id) ,HttpStatus.ACCEPTED);
    }

}
