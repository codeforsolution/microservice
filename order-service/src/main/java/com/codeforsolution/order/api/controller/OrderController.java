package com.codeforsolution.order.api.controller;

import com.codeforsolution.common.dto.OrderEvent;
import com.codeforsolution.order.api.dto.Payment;
import com.codeforsolution.order.api.dto.TransactionRequest;
import com.codeforsolution.order.api.exception.OrderNotFoundException;
import com.codeforsolution.order.api.kafka.OrderProducer;
import com.codeforsolution.order.api.model.Order;
import com.codeforsolution.order.api.repository.OrderRepository;
import com.codeforsolution.order.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProducer orderProducer;

    /**
     * @param transactionRequest
     * @return
     */
/*    @PostMapping
    public Order placeOrder(@RequestBody TransactionRequest transactionRequest) {
        //call inventory service and place the order if product is in stock
        return orderService.placeOrder(transactionRequest);
    }*/

    @PostMapping
    public String placeOrder(@RequestBody Order order) {

//        OrderEvent orderEvent = new OrderEvent();
//        orderEvent.setStatus("pending");
//        orderEvent.setMessage("order status is pending ");
//        orderEvent.setOrder(order);
        Payment payment = new Payment();
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setOrder(order);
        orderService.placeOrder(transactionRequest);
 //       orderProducer.sendMessage(orderEvent);
        return "Order placed successfully";
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
        System.out.println("--------Order controller call ----------------");
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
