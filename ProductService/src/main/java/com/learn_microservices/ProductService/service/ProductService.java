package com.learn_microservices.ProductService.service;

import com.learn_microservices.ProductService.entity.Product;
import com.learn_microservices.ProductService.model.ProductRequest;

public interface ProductService {
    long addProduct(ProductRequest productrequest);
    Product getProdById(Long id);
}
