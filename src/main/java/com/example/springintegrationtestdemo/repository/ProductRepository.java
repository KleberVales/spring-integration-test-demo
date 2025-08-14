package com.example.springintegrationtestdemo.repository;

import com.example.springintegrationtest.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
