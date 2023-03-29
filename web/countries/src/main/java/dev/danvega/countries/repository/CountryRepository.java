package dev.danvega.countries.repository;

import dev.danvega.countries.model.Country;
import org.springframework.data.repository.ListCrudRepository;

public interface CountryRepository extends ListCrudRepository<Country,Integer> {
}
