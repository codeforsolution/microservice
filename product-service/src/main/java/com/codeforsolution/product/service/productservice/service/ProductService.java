package com.codeforsolution.product.service.productservice.service;

import com.codeforsolution.product.service.productservice.dto.ProductRequest;
import com.codeforsolution.product.service.productservice.dto.ProductResponse;
import com.codeforsolution.product.service.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    public ProductResponse createProduct(ProductRequest productRequestuct);

    List<ProductResponse> getAllProducts();
}
