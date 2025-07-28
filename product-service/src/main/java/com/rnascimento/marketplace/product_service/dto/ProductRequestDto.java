package com.rnascimento.marketplace.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String category;
}

