package com.codeforsolution.order.api.service.impl;

import com.codeforsolution.order.api.common.Payment;
import com.codeforsolution.order.api.common.TransactionRequest;
import com.codeforsolution.order.api.model.Order;
import com.codeforsolution.order.api.repository.OrderRepository;
import com.codeforsolution.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    /**
     * @param transactionRequest
     * @return
     */
    @Override
    public Order saveOrder(TransactionRequest transactionRequest) {
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getOrderId());
        payment.setAmount(order.getPrice());
        //Rest call
        return orderRepository.save(order);
    }
}
