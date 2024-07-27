package com.codeforsolution.api.inventory.service.controller;

import com.codeforsolution.api.inventory.service.service.InvertoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InvertoryService invertoryService;

    @GetMapping("/{sku-code}")
    public boolean isInStock(@PathVariable("sku-code") String skuCode){
        return invertoryService.isInStock(skuCode);
    }
}
