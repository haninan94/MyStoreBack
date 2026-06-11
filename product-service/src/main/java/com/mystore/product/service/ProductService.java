package com.mystore.product.service;

import com.mystore.common.exception.BusinessException;
import com.mystore.product.domain.Product;
import com.mystore.product.dto.ProductRequest;
import com.mystore.product.dto.ProductResponse;
import com.mystore.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductResponse createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
        return new ProductResponse(productRepository.save(product));
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }

    public ProductResponse getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BusinessException("PRODUCT_001", "상품을 찾을 수 없습니다."));
        return new ProductResponse(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
