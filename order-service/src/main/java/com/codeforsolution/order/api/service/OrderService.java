package com.codeforsolution.order.api.service;

import com.codeforsolution.order.api.entity.Order;
import com.codeforsolution.order.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

}
