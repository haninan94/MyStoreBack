package com.mystore.product.dto;

import com.mystore.product.domain.Product;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }
}
