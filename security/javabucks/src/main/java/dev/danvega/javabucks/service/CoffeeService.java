package dev.danvega.javabucks.service;

import dev.danvega.javabucks.model.Coffee;
import dev.danvega.javabucks.model.Size;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class CoffeeService {

    private List<Coffee> coffees = new ArrayList<>();
    AtomicInteger id = new AtomicInteger(0);

    public List<Coffee> findAll() {
        return coffees;
    }

    public Optional<Coffee> findOne(Integer id) {
        return coffees.stream().filter(coffee -> coffee.id() == id).findFirst();
    }

    public Coffee delete(Integer id) {
        Coffee coffee = coffees.stream().filter(c -> c.id() == id)
                .findFirst().orElseThrow(() -> new IllegalArgumentException());
        coffees.remove(coffee);
        return coffee;
    }

    public Coffee create(Coffee coffee) {
        Coffee newCoffee = new Coffee(id.incrementAndGet(),
                coffee.name(),
                coffee.size(),
                coffee.price(),
                coffee.cost());
        coffees.add(newCoffee);
        return newCoffee;
    }

    public List<Coffee> findAllBySize(Size size) {
        return coffees.stream().filter(coffee -> coffee.size() == size).collect(Collectors.toList());
    }

    @PostConstruct
    private void init() {
        coffees.add(new Coffee(id.incrementAndGet(), "Caffè Americano", Size.GRANDE, BigDecimal.valueOf(4.99),BigDecimal.valueOf(2.99)));
        coffees.add(new Coffee(id.incrementAndGet(), "Caffè Latte", Size.VENTI, BigDecimal.valueOf(4.99),BigDecimal.valueOf(2.99)));
        coffees.add(new Coffee(id.incrementAndGet(), "Caffè Caramel Macchiato", Size.TALL, BigDecimal.valueOf(4.99),BigDecimal.valueOf(2.99)));
    }

}