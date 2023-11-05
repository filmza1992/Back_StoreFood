package com.example.FoodApi.payload;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class AddProductPayload {
    private String productName;
    private int price; 
    private String image;
}

