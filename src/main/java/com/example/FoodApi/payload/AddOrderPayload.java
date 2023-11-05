package com.example.FoodApi.payload;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@RequiredArgsConstructor
public class AddOrderPayload {
    private long customerId;
    private List<OrderProductPayload> orderProduct;
    
}