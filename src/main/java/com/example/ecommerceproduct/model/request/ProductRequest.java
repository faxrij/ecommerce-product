package com.example.ecommerceproduct.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductRequest {

    @NotEmpty
    private String name;

    @NotNull
    @Positive
    private Double price;
}
