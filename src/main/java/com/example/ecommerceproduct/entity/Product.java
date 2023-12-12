package com.example.ecommerceproduct.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;
}
