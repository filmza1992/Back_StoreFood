package com.example.FoodApi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime; 
import jakarta.persistence.*;

@Getter @Setter
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private long id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "price" , nullable = false)
    private int price;

    @Column(name = "create_at" , nullable = false)
    private LocalDateTime createAt;

    @Column(name = "image" , length = 1000)
    private String image;
}

