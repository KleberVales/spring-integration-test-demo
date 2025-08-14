package com.example.springintegrationtestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIntegrationTestDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationTestDemoApplication.class, args);
    }
}

/*

    - Criar endpoints REST para ProductController (GET, POST).
    - Usar @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) e TestRestTemplate para fazer requisições reais.
    - Testar persistência usando banco H2 em memória.

*/
