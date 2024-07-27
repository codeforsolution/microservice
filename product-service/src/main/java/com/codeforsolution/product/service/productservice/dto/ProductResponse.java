package com.codeforsolution.product.service.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class ProductResponse {
    private final Long productId;
    private final String name;
    private final Double price;
    private final String description;
}
