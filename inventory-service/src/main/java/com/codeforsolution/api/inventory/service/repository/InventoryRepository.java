package com.codeforsolution.api.inventory.service.repository;

import com.codeforsolution.api.inventory.service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySkuCode(List<String> skuCode);
}
