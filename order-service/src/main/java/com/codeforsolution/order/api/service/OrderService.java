package com.codeforsolution.order.api.service;

import com.codeforsolution.order.api.dto.TransactionRequest;
import com.codeforsolution.order.api.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public Order placeOrder(TransactionRequest transactionRequest);

    List<Order> getOrders();

    Optional<Order> getOrdersById(Long id);

    boolean cancelOrderById(Long id);
}
