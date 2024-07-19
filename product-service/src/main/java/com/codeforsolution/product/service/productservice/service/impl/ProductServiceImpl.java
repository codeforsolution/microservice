package com.codeforsolution.product.service.productservice.service.impl;

import com.codeforsolution.product.service.productservice.model.Product;
import com.codeforsolution.product.service.productservice.repository.ProductRepository;
import com.codeforsolution.product.service.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    /**
     * @param product
     * @return product
     */
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * @return
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
