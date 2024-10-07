package com.codeforsolution.api.inventory.service.service;

import com.codeforsolution.api.inventory.service.dto.InventoryResponse;

import java.util.List;

public interface InvertoryService {


    List<InventoryResponse> isInStock(List<String> skuCode);
}
