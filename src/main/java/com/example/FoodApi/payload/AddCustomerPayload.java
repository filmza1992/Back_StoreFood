package com.example.FoodApi.payload;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class AddCustomerPayload {
    private String firstName;
    private String lastName; 
    private String customerUser;
    private String password;
}

