package com.codeforsolution.api.inventory.service.controller;

import com.codeforsolution.api.inventory.service.dto.InventoryResponse;
import com.codeforsolution.api.inventory.service.service.InvertoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InvertoryService invertoryService;

    @GetMapping("/{sku-code}")
    public List<InventoryResponse> isInStock(@RequestParam("sku-code") List<String> skuCode){
        System.out.println("test");
        return invertoryService.isInStock(skuCode);
    }
}
