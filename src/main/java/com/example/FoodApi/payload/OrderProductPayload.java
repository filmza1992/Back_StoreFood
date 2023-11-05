package com.example.FoodApi.payload;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class OrderProductPayload {
    private long productId;
    private int amount;
}
