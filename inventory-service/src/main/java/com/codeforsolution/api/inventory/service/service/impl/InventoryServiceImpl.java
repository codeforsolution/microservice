package com.codeforsolution.api.inventory.service.service.impl;

import com.codeforsolution.api.inventory.service.repository.InventoryRepository;
import com.codeforsolution.api.inventory.service.service.InvertoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InvertoryService {

    private final InventoryRepository inventoryRepository;
    /**
     * @param skuCode
     * @return
     */
    @Override
    public boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
