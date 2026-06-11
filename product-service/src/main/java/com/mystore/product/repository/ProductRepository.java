package com.mystore.product.repository;

import com.mystore.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
