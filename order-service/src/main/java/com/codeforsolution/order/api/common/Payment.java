package com.codeforsolution.order.api.common;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Payment {

    private Long paymentId;
    private String paymentStatus;
    private String transactionId;
    private Long orderId;
    private Double amount;

}
