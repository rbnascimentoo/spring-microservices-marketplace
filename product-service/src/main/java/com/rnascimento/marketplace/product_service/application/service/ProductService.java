package com.rnascimento.marketplace.product_service.application.service;

import com.rnascimento.marketplace.product_service.domain.model.Product;
import com.rnascimento.marketplace.product_service.dto.ProductRequestDto;
import com.rnascimento.marketplace.product_service.dto.ProductResponseDto;
import com.rnascimento.marketplace.product_service.domain.port.in.ProductUseCase;
import com.rnascimento.marketplace.product_service.domain.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public ProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return productRepositoryPort.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto findById(Long id) {
        Product product = productRepositoryPort.findById(id);
        return product != null ? toResponseDto(product) : null;
    }

    @Override
    public ProductResponseDto create(ProductRequestDto dto) {
        Product product = toEntity(dto);
        Product saved = productRepositoryPort.save(product);
        return toResponseDto(saved);
    }

    @Override
    public ProductResponseDto update(Long id, ProductRequestDto dto) {
        Product product = productRepositoryPort.findById(id);
        if (product == null) return null;
        updateEntity(product, dto);
        Product updated = productRepositoryPort.save(product);
        return toResponseDto(updated);
    }

    @Override
    public boolean delete(Long id) {
        return productRepositoryPort.delete(id);
    }

    private Product toEntity(ProductRequestDto dto) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .category(dto.getCategory())
                .build();
    }

    private void updateEntity(Product product, ProductRequestDto dto) {
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setCategory(dto.getCategory());
    }

    private ProductResponseDto toResponseDto(Product product) {
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .category(product.getCategory())
                .build();
    }
}

