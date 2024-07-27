package com.codeforsolution.order.api.service.impl;

import com.codeforsolution.order.api.common.Payment;
import com.codeforsolution.order.api.common.TransactionRequest;
import com.codeforsolution.order.api.model.Order;
import com.codeforsolution.order.api.repository.OrderRepository;
import com.codeforsolution.order.api.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;
    /**
     * @param transactionRequest
     * @return
     */
    @Override
    public Order placeOrder(TransactionRequest transactionRequest) {
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getOrderId());
        payment.setAmount(order.getPrice());
        //Rest call
        ////call inventory service and place the order if product is in stock
        Boolean result = webClient.get()
                .uri("http://book-iklu14efh2:8787/inventory-service/api/inventory/"+order.getName())
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if(result){

            return orderRepository.save(order);
        } else{
             throw  new RuntimeException("Not pleced ");
        }
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
