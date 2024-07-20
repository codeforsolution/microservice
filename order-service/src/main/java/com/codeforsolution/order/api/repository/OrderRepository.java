package com.codeforsolution.order.api.repository;

import com.codeforsolution.order.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
