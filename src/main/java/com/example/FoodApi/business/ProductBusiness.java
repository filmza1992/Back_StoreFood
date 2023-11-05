package com.example.FoodApi.business;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodApi.json.ProductJson;
import com.example.FoodApi.model.Product;
import com.example.FoodApi.payload.AddProductPayload;
import com.example.FoodApi.service.ProductService;



@Service
public class ProductBusiness {
    @Autowired
    ProductService productService;

    public void insert(AddProductPayload payload){
        Product product = new Product();
        product.setName(payload.getProductName());
        product.setPrice(payload.getPrice());
        product.setCreateAt(LocalDateTime.now());
        product.setImage(payload.getImage());
        productService.save(product);
    }

    public void update(long id , AddProductPayload payload){
        Product product = productService.findById(id);
        product.setName(payload.getProductName());
        product.setPrice(payload.getPrice());
        productService.save(product);
    }

    public List<ProductJson> getProducts(){
        List<ProductJson> jsons = ProductJson.packJsons(productService.findAll());
        return jsons;
    }
}