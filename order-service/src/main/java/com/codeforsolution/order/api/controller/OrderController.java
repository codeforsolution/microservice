package com.codeforsolution.order.api.controller;

import com.codeforsolution.order.api.entity.Order;
import com.codeforsolution.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    public ResponseEntity<Order> bookOrder(@RequestBody Order order){
        return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
    }
}
