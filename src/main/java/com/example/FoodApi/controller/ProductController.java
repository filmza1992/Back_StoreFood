package com.example.FoodApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.FoodApi.business.ProductBusiness;
import com.example.FoodApi.json.ProductJson;
import com.example.FoodApi.payload.AddProductPayload;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductBusiness productBusiness;

   
    @GetMapping("/")
    public ResponseEntity<List<ProductJson>> getProducts() {
        
        return new ResponseEntity<>(productBusiness.getProducts() ,HttpStatus.ACCEPTED);
    }

    @PostMapping("/save")
    public ResponseEntity<String> addProduct(@RequestBody AddProductPayload addProductPayload){
        productBusiness.insert(addProductPayload);
        return new ResponseEntity<>("Create Product "+addProductPayload.getProductName(),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable(name = "id") Long id ,@RequestBody AddProductPayload payload){
        productBusiness.update(id , payload);
        return new ResponseEntity<>("Update Success"+Long.toString(id) ,HttpStatus.ACCEPTED);
    }



}
