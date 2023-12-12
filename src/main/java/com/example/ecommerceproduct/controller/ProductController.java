package com.example.ecommerceproduct.controller;

import com.example.ecommerceproduct.model.request.ProductRequest;
import com.example.ecommerceproduct.model.response.ProductResponse;
import com.example.ecommerceproduct.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody @Valid ProductRequest productRequest) {
        productService.addProduct(productRequest);
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }
}
