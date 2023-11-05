package com.example.FoodApi.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.FoodApi.model.Customer;
import com.example.FoodApi.model.Order;
import com.example.FoodApi.payload.OrderProductPayload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
public class OrderJson {

    private long id;
    private CustomerJson customer;
    private LocalDateTime createAt;
    private String status;

    public static OrderJson packJson(Order order){
        OrderJson json = new OrderJson();

        json.setId(order.getId());
        json.setCustomer(CustomerJson.packJson(order.getCustomer()));
        json.setCreateAt(order.getCreateAt());
        json.setStatus(order.getStatus());
        return json;
    }

    public static List<OrderJson> packJsons(List<Order> orders){
        List<OrderJson> jsons = new ArrayList<>();
        for (Order order : orders){
            jsons.add(OrderJson.packJson(order));
        }
        return jsons;
    }

}
