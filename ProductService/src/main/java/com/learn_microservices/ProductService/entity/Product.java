package com.learn_microservices.ProductService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "Price")
    private long price;

    @Column(name = "Quantity")
    private long quantity;

}
