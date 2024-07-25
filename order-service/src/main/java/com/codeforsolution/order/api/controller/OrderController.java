package com.codeforsolution.order.api.controller;

import com.codeforsolution.order.api.common.Payment;
import com.codeforsolution.order.api.common.TransactionRequest;
import com.codeforsolution.order.api.model.Order;
import com.codeforsolution.order.api.repository.OrderRepository;
import com.codeforsolution.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order saveOrder(@RequestBody TransactionRequest transactionRequest){

        return orderService.saveOrder(transactionRequest);
    }
}
