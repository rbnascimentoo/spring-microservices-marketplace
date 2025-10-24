 package com.rnascimento.marketplace.product_service.domain.port.out;

import com.rnascimento.marketplace.product_service.domain.model.Product;
import java.util.List;

public interface ProductRepositoryPort {
    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    boolean delete(Long id);
}

