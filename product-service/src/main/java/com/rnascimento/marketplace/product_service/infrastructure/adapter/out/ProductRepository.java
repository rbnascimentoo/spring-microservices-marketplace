package com.rnascimento.marketplace.product_service.infrastructure.adapter.out;

import com.rnascimento.marketplace.product_service.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

