package dev.danvega.countries.controller;

import dev.danvega.countries.model.Country;
import dev.danvega.countries.repository.CountryRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CountryController {

    private final CountryRepository repository;

    public CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public List<Country> findAllCountries() {
        return repository.findAll();
    }

}
