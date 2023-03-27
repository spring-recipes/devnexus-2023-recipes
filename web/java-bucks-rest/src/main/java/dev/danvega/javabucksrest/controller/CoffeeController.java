package dev.danvega.javabucksrest.controller;

import dev.danvega.javabucksrest.model.Coffee;
import dev.danvega.javabucksrest.model.CoffeeImage;
import dev.danvega.javabucksrest.model.Size;
import dev.danvega.javabucksrest.service.CoffeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/coffee")
@CrossOrigin
public class CoffeeController {

    private final CoffeeService coffeeService;
    private final RestTemplate restTemplate;

    public CoffeeController(CoffeeService coffeeService, RestTemplate restTemplate) {
        this.coffeeService = coffeeService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Coffee> findAll() {
        return coffeeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Coffee> findOne(@PathVariable Integer id) {
        return coffeeService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coffee create(@Valid @RequestBody Coffee coffee) {
        return coffeeService.create(coffee);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<Coffee>> findAllBySize(@PathVariable Size size) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("my-custom-header", "my-custom-value");
        var coffee = coffeeService.findAllBySize(size);
        return new ResponseEntity<>(coffee, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/random")
    public CoffeeImage random() {
        return new CoffeeImage(new Random().nextInt(100),
                restTemplate.getForObject("https://coffee.alexflipnote.dev/random.json", String.class));
    }

}
