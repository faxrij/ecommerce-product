package com.example.ecommerceproduct.model.response;

import com.example.ecommerceproduct.entity.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private long id;
    private String name;
    private Double price;

    public static ProductResponse fromEntity(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .price(product.getPrice())
                .name(product.getName())
                .build();
    }
}
