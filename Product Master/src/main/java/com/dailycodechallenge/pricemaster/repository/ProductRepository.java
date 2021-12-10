package com.dailycodechallenge.pricemaster.repository;

import com.dailycodechallenge.pricemaster.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByProductCode(String code);
}
