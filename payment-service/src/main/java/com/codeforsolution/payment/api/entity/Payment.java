package com.codeforsolution.payment.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="payment_table")
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private Long paymentId;
    private String paymentStatus;
    private String transactionId;
    private Long orderId;
    private Double amount;

}
