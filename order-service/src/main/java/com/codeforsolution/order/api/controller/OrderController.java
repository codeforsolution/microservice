package com.codeforsolution.order.api.controller;

import com.codeforsolution.order.api.common.Payment;
import com.codeforsolution.order.api.common.TransactionRequest;
import com.codeforsolution.order.api.exception.OrderNotFoundException;
import com.codeforsolution.order.api.model.Order;
import com.codeforsolution.order.api.repository.OrderRepository;
import com.codeforsolution.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    /**
     * @param transactionRequest
     * @return
     */
    @PostMapping
    public Order saveOrder(@RequestBody TransactionRequest transactionRequest) {

        return orderService.saveOrder(transactionRequest);
    }

    /**
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<>(orderService.getOrders(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrdersById(@PathVariable Long id) {
        Optional<Order> ordersById = orderService.getOrdersById(id);
        return ordersById.map(order -> new ResponseEntity<>(order, HttpStatus.OK)).orElseThrow(() -> new OrderNotFoundException("Invalid order id"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelOrderById(@PathVariable Long id) {
        Optional<Order> isOrderPresent = orderService.getOrdersById(id);
        if(isOrderPresent.isPresent()){
            boolean isDeleted = orderService.cancelOrderById(id);
            if (isDeleted) {
                return ResponseEntity.ok("Order delete successfully!");
            } else {
                return ResponseEntity.notFound().build();
            }
        }else{
            throw new OrderNotFoundException("Invalid order id");
        }

    }


}
