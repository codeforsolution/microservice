package com.codeforsolution.product.service.productservice.config;

import com.codeforsolution.product.service.productservice.dto.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="order-service")
public interface OrderFeignClientService {

    @GetMapping("api/order/{id}")
    public ResponseEntity<OrderResponse> getOrdersById(@PathVariable Long id);
}
