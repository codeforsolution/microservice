package com.codeforsolution.order.api.service;

import com.codeforsolution.order.api.common.TransactionRequest;
import com.codeforsolution.order.api.model.Order;

public interface OrderService {

    public Order saveOrder(TransactionRequest transactionRequest);
}
