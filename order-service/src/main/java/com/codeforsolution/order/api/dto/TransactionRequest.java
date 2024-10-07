package com.codeforsolution.order.api.dto;

import com.codeforsolution.order.api.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

public class TransactionRequest {
    private Order order;
    private Payment payment;

    public TransactionRequest() {
    }

    public TransactionRequest(Order order, Payment payment) {
        this.order = order;
        this.payment = payment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionRequest that = (TransactionRequest) o;
        return Objects.equals(order, that.order) && Objects.equals(payment, that.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, payment);
    }

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "order=" + order +
                ", payment=" + payment +
                '}';
    }
}
