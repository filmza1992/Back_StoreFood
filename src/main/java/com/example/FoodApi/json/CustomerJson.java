package com.example.FoodApi.json;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.FoodApi.model.Customer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CustomerJson {
    private long id;
    private String firstName;
    private String lastName;
    private String cUser;
    private String password;
    private LocalDateTime createAt;

    public static CustomerJson packJson(Customer customer){
        CustomerJson json = new CustomerJson();
        json.setId(customer.getId());
        json.setFirstName(customer.getFirstName());
        json.setLastName(customer.getLastName());
        json.setCUser(customer.getCustomerUser());
        json.setPassword(customer.getPassword());
        json.setCreateAt(customer.getCreatedAt());
       
        return json;
    }

    public static List<CustomerJson> packJsons(List<Customer> customers){
        List<CustomerJson> jsons = new ArrayList<>();
        for (com.example.FoodApi.model.Customer customer : customers){
            jsons.add(CustomerJson.packJson(customer));
        }
        return jsons;
    }
}
