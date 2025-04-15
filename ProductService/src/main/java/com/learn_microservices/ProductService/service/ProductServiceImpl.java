package com.learn_microservices.ProductService.service;

import com.learn_microservices.ProductService.entity.Product;
import com.learn_microservices.ProductService.model.ProductRequest;
import com.learn_microservices.ProductService.repository.ProductRepository;
import com.learn_microservices.ProductService.exception.ProductServiceCustomException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding product");
        Product product = Product.builder().productName(productRequest.getName()).quantity(productRequest.getQuantity()).price(productRequest.getPrice()).build();
        productRepository.save(product);
        log.info("Added product");
        return product.getProductId();
    }

    @Override
    public Product getProdById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductServiceCustomException("Product not found", "PRODUCT_NOT_FOUND"));
        return product;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("reduce quantity of {} for product id: {}", quantity, productId);
        Product product = productRepository.findById(productId).orElseThrow(()-> new ProductServiceCustomException("Product not found", "PRODUCT_NOT_FOUND"));
        if(product.getQuantity()<quantity){
            throw new ProductServiceCustomException("Doesn't have sufficient quantity", "INSUFFICIENT_QUANTITY");
        }
        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
        log.info("Prod Quantity updated");

    }
}
