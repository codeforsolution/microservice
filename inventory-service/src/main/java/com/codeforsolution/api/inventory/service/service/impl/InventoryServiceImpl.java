package com.codeforsolution.api.inventory.service.service.impl;

import com.codeforsolution.api.inventory.service.dto.InventoryResponse;
import com.codeforsolution.api.inventory.service.repository.InventoryRepository;
import com.codeforsolution.api.inventory.service.service.InvertoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InvertoryService {

    private final InventoryRepository inventoryRepository;
    /**
     * @param List<skuCode>
     * @return List<InventoryResponse>
     */
    @Override
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).stream().map(inventory ->
            InventoryResponse.builder().skuCode(inventory.getSkuCode())
                    .inInStock(inventory.getQuantity()>0)
                    .build()
        ).toList();
    }
}
