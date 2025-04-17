package com.example.OrderService.service;

import com.example.OrderService.entity.Order;
import com.example.OrderService.external.clients.ProductService;
import com.example.OrderService.model.OrderResponse;
import com.example.OrderService.model.ProductDetails;
import com.example.OrderService.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductService productService;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    OrderService orderService = new OrderServiceImpl();

    @DisplayName("getOrderDetails Success")
    @Test
    void getOrderDetails_success(){
//        sample data
        Order order = Order.builder()
                .quantity(12)
                .orderStatus("Places")
                .amount(1200)
                .orderDate(Instant.now())
                .id(1)
                .productId(111)
                .build();
        ProductDetails productDetails = ProductDetails.builder()
                .price(100)
                .productId(111)
                .productName("PINS")
                .quantity(15)
                .build();
//        Mocking
        when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));
        when(restTemplate.getForObject("http://PRODUCT-SERVICE/product/"+order.getProductId(), ProductDetails.class)).thenReturn(productDetails);
//        Actual
        OrderResponse orderResponse = orderService.getOrderDetails(1);
//        Verify
        verify(orderRepository, times(1)).findById(anyLong());
        verify(restTemplate, times(1)).getForObject("http://PRODUCT-SERVICE/product/"+order.getProductId(), ProductDetails.class);

//        Assert
        Assertions.assertNotNull(orderResponse);
        Assertions.assertEquals(orderResponse.getOrderId(), order.getId());
    }
}