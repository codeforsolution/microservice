package com.codeforsolution.order.api.service.impl;

import com.codeforsolution.order.api.common.Payment;
import com.codeforsolution.order.api.common.TransactionRequest;
import com.codeforsolution.order.api.exception.OrderNotFoundException;
import com.codeforsolution.order.api.model.Order;
import com.codeforsolution.order.api.repository.OrderRepository;
import com.codeforsolution.order.api.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    @Value("inventorty.base.url")
    private String inventoryBaseURL;
    /**
     * @param transactionRequest
     * @return
     */

    @Override
//    @CircuitBreaker(name="placeOrderCall", fallbackMethod = "fallbackDoOrder")
    public Order placeOrder(TransactionRequest transactionRequest) {
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getOrderId());
        payment.setAmount(order.getPrice());
        //Rest call
        ////call inventory service and place the order if product is in stock
        Boolean result = webClient.get()
                .uri(inventoryBaseURL+order.getName())
            //    .header("Authentication", "")
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        if(result){

            return orderRepository.save(order);
        } else{
             throw  new RuntimeException("Order not placed ");
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


    public Order fallbackDoOrder(Throwable throwable){
            throw new OrderNotFoundException("Invertory service not avialable");
    }
}
