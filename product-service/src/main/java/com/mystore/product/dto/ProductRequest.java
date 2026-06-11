package com.mystore.product.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
}
