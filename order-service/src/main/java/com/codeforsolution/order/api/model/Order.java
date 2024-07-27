package com.codeforsolution.order.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="order_table")
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private final Long orderId;
    private final String name;
    private final int quantity;
    private final Double price;

}
