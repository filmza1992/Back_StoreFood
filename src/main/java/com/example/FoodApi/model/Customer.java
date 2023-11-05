package com.example.FoodApi.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "customers", uniqueConstraints = @UniqueConstraint(name = "Unique_cUser" , columnNames = "c_user"))
public class Customer {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private long id;

    @Column(name = "first_name" , nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "c_user" , unique = true , nullable = false)
    private String customerUser;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "created_at" , nullable = false)
    private LocalDateTime createdAt;

    public Customer(String firstName, String lastName, String cUser, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerUser = cUser;
        this.password = password;
    }

    
}