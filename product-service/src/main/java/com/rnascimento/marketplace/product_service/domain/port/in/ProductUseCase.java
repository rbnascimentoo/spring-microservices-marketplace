package com.rnascimento.marketplace.product_service.domain.port.in;

import com.rnascimento.marketplace.product_service.dto.ProductRequestDto;
import com.rnascimento.marketplace.product_service.dto.ProductResponseDto;
import java.util.List;

public interface ProductUseCase {
    List<ProductResponseDto> findAll();
    ProductResponseDto findById(Long id);
    ProductResponseDto create(ProductRequestDto dto);
    ProductResponseDto update(Long id, ProductRequestDto dto);
    boolean delete(Long id);
}

