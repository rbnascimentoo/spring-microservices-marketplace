package com.rnascimento.marketplace.product_service.infrastructure.adapter.out;

import com.rnascimento.marketplace.product_service.domain.model.Product;
import com.rnascimento.marketplace.product_service.domain.port.out.ProductRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {
    private final ProductRepository productRepository;

    @Autowired
    public ProductRepositoryAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOpt = productRepository.findById(id);
        return productOpt.orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
