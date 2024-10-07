package com.codeforsolution.order.api.dto;

import lombok.*;


@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
public class Payment {

    private Long paymentId;
    private String paymentStatus;
    private String transactionId;
    private Long orderId;
    private Double amount;

}
