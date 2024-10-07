package com.codeforsolution.product.service.productservice.dto;


import lombok.*;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderResponse {

    private final Long orderId;
    private final String name;
    private final int quantity;
    private final Double price;

}
