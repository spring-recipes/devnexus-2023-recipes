package dev.danvega.javabucksrest;

import dev.danvega.javabucksrest.model.Coffee;
import dev.danvega.javabucksrest.model.Size;
import dev.danvega.javabucksrest.repository.CoffeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(CoffeeRepository repository) {
		return args -> {
			List<Coffee> coffees = List.of(
					new Coffee(null, "Caffè Americano", Size.GRANDE),
					new Coffee(null, "Caffè Latte", Size.VENTI),
					new Coffee(null, "Caffè Caramel Macchiato", Size.TALL));
			repository.saveAll(coffees);
		};
	}

}
