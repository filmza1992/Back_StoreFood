package com.example.FoodApi.business;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FoodApi.json.OrderJson;
import com.example.FoodApi.key_composite.OrderProductKey;
import com.example.FoodApi.model.Order;
import com.example.FoodApi.model.OrderProduct;
import com.example.FoodApi.payload.AddOrderPayload;
import com.example.FoodApi.payload.OrderProductPayload;
import com.example.FoodApi.service.CustomerService;
import com.example.FoodApi.service.OrderProductService;
import com.example.FoodApi.service.OrderService;
import com.example.FoodApi.service.ProductService;

@Service
public class OrderBusiness {
    
    @Autowired
    OrderService orderService;

    @Autowired
    OrderProductService orderProductService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;
    public void insert(AddOrderPayload payload){
        Order order = new Order();
        order.setCustomer(customerService.findById(payload.getCustomerId()));
        order.setCreateAt(LocalDateTime.now());
        order.setStatus("In Progess");
        orderService.save(order);
       
        for(OrderProductPayload orderProductPayload : payload.getOrderProduct()){
            OrderProductKey orderProductKey = new OrderProductKey();
            orderProductKey.setOrderId(order.getId()); 
            orderProductKey.setProductId(productService.findById(orderProductPayload.getProductId()).getId());
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setId(orderProductKey);
            orderProduct.setOrder(order);
            orderProduct.setProduct(productService.findById(orderProductPayload.getProductId()));
            orderProduct.setAmount(orderProductPayload.getAmount());
            System.out.println(orderProductPayload);
            orderProductService.save(orderProduct);
        }

    }

    public void updateOrder(long id ,AddOrderPayload payload){
        Order order = orderService.findById(id);
        order.setCustomer(customerService.findById(payload.getCustomerId()));
        order.setStatus("Success");
        

        orderService.save(order);
    }

    public List<OrderJson> getAll(){
        List<OrderJson> jsons = OrderJson.packJsons(orderService.findAll());
        return jsons;
    }
}
