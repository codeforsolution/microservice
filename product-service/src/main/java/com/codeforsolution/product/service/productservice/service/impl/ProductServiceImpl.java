package com.codeforsolution.product.service.productservice.service.impl;

import com.codeforsolution.product.service.productservice.config.OrderFeignClientService;
import com.codeforsolution.product.service.productservice.dto.OrderResponse;
import com.codeforsolution.product.service.productservice.dto.ProductRequest;
import com.codeforsolution.product.service.productservice.dto.ProductResponse;
import com.codeforsolution.product.service.productservice.model.Product;
import com.codeforsolution.product.service.productservice.repository.ProductRepository;
import com.codeforsolution.product.service.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final OrderFeignClientService orderFeignClientService;

    /**
     * @param productRequest
     * @return product
     */
    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder().name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getProductId());
        return mapToProductResponse(product);

    }

    /**
     * @return
     */
    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
       ResponseEntity<OrderResponse> orderResponse = orderFeignClientService.getOrdersById(1L);
       log.info("------------------Order Response----------------->",orderResponse.getHeaders());
        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

    }
}
