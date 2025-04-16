package com.example.OrderService.service;

import com.example.OrderService.entity.Order;
import com.example.OrderService.external.clients.ProductService;
import com.example.OrderService.model.OrderRequest;
import com.example.OrderService.model.OrderResponse;
import com.example.OrderService.model.ProductDetails;
import com.example.OrderService.repository.OrderRepository;
import com.netflix.discovery.converters.Auto;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public long placeOrder(OrderRequest orderRequest) {

        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
        Order order = Order.builder()
                .productId(orderRequest.getProductId())
                .orderStatus("CREATED")
                .orderDate(Instant.now())
                .amount(orderRequest.getTotalAmount())
                .quantity(orderRequest.getQuantity())
                .build();
        log.info("Order HERE :{}", order);
        order = orderRepository.save(order);
        return order.getId();
    }

    @Override
    public OrderResponse getOrderDetails(long orderId) {
        Order order = orderRepository.findById(orderId).get();
        ProductDetails productDetails = restTemplate.getForObject("http://PRODUCT-SERVICE/product/"+orderId, ProductDetails.class);
        OrderResponse orderResponse = OrderResponse.builder()
                .orderId(order.getId())
                .orderStatus(order.getOrderStatus())
                .amount(order.getAmount())
                .orderDate(order.getOrderDate())
                .productDetails(productDetails)
                .build();
        return orderResponse;
    }
}
