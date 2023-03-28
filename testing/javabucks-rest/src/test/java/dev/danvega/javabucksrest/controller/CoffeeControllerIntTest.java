package dev.danvega.javabucksrest.controller;

import dev.danvega.javabucksrest.model.Coffee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoffeeControllerIntTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void findAll() {
        ResponseEntity<List<Coffee>> exchange = testRestTemplate.exchange("/api/coffee",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Coffee>>() {});

        assertEquals(3,exchange.getBody().size());
    }
}