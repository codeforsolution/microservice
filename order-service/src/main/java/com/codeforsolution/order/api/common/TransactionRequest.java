package com.codeforsolution.order.api.common;

import com.codeforsolution.order.api.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {
    private Order order;
    private Payment payment;
}
