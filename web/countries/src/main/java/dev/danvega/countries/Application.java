package dev.danvega.countries;

import dev.danvega.countries.model.Country;
import dev.danvega.countries.repository.CountryRepository;
import dev.danvega.countries.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CountryService service,CountryRepository repository) {
        return args -> {
            Mono<List<Country>> countries = service.getCountries();
            countries.subscribe(response -> {
                repository.saveAll(response);
            });
        };
    }

}
