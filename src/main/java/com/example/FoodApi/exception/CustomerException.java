package com.example.FoodApi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomerException extends RuntimeException{
    public CustomerException() {
        super("Customer Exception");
    }
}
