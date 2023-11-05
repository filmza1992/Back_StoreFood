package com.example.FoodApi.key_composite;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class OrderProductKey implements Serializable{
    
    @Column(name = "order_id")
    long orderId;

    @Column(name = "product_id")
    long productId;
}
