package dev.danvega.postgresdemo.config;

import dev.danvega.postgresdemo.model.Coffee;
import dev.danvega.postgresdemo.model.Size;
import dev.danvega.postgresdemo.repository.CoffeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseLoader.class);

    private final CoffeeRepository repository;

    public DatabaseLoader(CoffeeRepository coffeeRepository) {
        this.repository = coffeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Coffee> coffees = List.of(new Coffee(null, "Caffè Americano", Size.GRANDE),
                new Coffee(null, "Caffè Latte", Size.VENTI),
                new Coffee(null, "Caffè Caramel Macchiato", Size.TALL));
        repository.saveAll(coffees);
    }

}
