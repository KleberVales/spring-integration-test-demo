package com.example.springintegrationtestdemo.controller;

import com.example.springintegrationtestdemo.entity.Product;
import com.example.springintegrationtestdemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
}
