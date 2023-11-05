package com.example.FoodApi.payload;


import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class AddOwnerPayload {
    private String username;
    private String email; 
    private String password;
    private String birthDay;
}

