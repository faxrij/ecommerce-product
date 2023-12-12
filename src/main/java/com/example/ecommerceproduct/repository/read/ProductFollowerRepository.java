package com.example.ecommerceproduct.repository.read;

import com.example.ecommerceproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFollowerRepository extends JpaRepository<Product, String> {

}
