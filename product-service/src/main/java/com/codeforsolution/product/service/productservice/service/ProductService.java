package com.codeforsolution.product.service.productservice.service;

import com.codeforsolution.product.service.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    public Product createProduct(Product product);

    List<Product> getAllProducts();
}
