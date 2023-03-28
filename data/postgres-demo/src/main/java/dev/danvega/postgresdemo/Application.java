package dev.danvega.postgresdemo;

import dev.danvega.postgresdemo.model.Coffee;
import dev.danvega.postgresdemo.model.Size;
import dev.danvega.postgresdemo.repository.CoffeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(CoffeeRepository repository) {
		return args -> {
			List<Coffee> coffees = List.of(new Coffee(null, "Caffè Americano", Size.GRANDE),
					new Coffee(null, "Caffè Latte", Size.VENTI),
					new Coffee(null, "Caffè Caramel Macchiato", Size.TALL));
			repository.saveAll(coffees);

			LOG.info("Fetching all rows from coffee table ------------------------");
			repository.findAll().forEach(System.out::println);
		};
	}

}
