package com.codeforsolution.order.api.service.impl;

import com.codeforsolution.order.api.common.Payment;
import com.codeforsolution.order.api.common.TransactionRequest;
import com.codeforsolution.order.api.model.Order;
import com.codeforsolution.order.api.repository.OrderRepository;
import com.codeforsolution.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * This method will return the all orders from the order table.
     * @return List<Order>
     */
    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Order> getOrdersById(Long id) {
        return orderRepository.findById(id);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean cancelOrderById(Long id) {
       try {
           orderRepository.deleteById(id);
           return true;
       } catch (Exception e){
           throw new RuntimeException("Error while deleting the order");
       }
    }
}
