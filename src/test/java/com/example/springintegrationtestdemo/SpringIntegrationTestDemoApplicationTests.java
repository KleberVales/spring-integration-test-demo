package com.example.springintegrationtestdemo;

import com.example.springintegrationtestdemo.entity.Product;
import com.example.springintegrationtestdemo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTestDemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository repository;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/products";
        repository.deleteAll();
    }

    @Test
    void shouldCreateProduct() {
        Product product = new Product("Notebook", 3500.0);

        ResponseEntity<Product> response = restTemplate.postForEntity(baseUrl, product, Product.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotNull();
    }

    @Test
    void shouldGetAllProducts() {
        repository.save(new Product("Mouse", 120.0));

        ResponseEntity<Product[]> response = restTemplate.getForEntity(baseUrl, Product[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(List.of(response.getBody())).hasSize(1);
    }
}
