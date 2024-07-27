package com.codeforsolution.product.service.productservice.controller;

import com.codeforsolution.product.service.productservice.dto.ProductRequest;
import com.codeforsolution.product.service.productservice.dto.ProductResponse;
import com.codeforsolution.product.service.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Test
    public void createProduct(){
        ProductRequest productRequest = new ProductRequest();
    }

}
