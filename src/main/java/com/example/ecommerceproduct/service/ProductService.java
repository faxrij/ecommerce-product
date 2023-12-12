package com.example.ecommerceproduct.service;

import com.example.ecommerceproduct.entity.Product;
import com.example.ecommerceproduct.model.request.ProductRequest;
import com.example.ecommerceproduct.model.response.ProductResponse;
import com.example.ecommerceproduct.repository.read.ProductFollowerRepository;
import com.example.ecommerceproduct.repository.write.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductService {

    private final ProductFollowerRepository productFollowerRepository;
    private final ProductRepository productRepository;

    public List<ProductResponse> getProducts() {
        return productFollowerRepository.findAll().stream().map(ProductResponse::fromEntity).toList();
    }

    public void addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
    }

    public ProductResponse getProduct(long id) {
        return productRepository.findById(id).map(ProductResponse::fromEntity).orElseThrow(() -> new RuntimeException("Error"));
    }
}
