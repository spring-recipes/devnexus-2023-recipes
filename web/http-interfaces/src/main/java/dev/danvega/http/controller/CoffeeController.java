package dev.danvega.http.controller;

import dev.danvega.http.client.CoffeeClient;
import dev.danvega.http.model.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    private final CoffeeClient coffeeClient;

    public CoffeeController(CoffeeClient coffeeClient) {
        this.coffeeClient = coffeeClient;
    }

    @GetMapping("/random")
    public Coffee random() {
        return coffeeClient.random();
    }

}
