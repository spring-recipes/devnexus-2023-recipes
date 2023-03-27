package dev.danvega.javabucksrest.controller;

import dev.danvega.javabucksrest.model.Coffee;
import dev.danvega.javabucksrest.service.CoffeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coffee")
@CrossOrigin
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
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
    public Coffee create(@Valid @RequestBody Coffee coffee) {
        return coffeeService.create(coffee);
    }

}
