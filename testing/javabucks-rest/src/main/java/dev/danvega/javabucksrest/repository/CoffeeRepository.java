package dev.danvega.javabucksrest.repository;

import dev.danvega.javabucksrest.model.Coffee;
import org.springframework.data.repository.ListCrudRepository;

public interface CoffeeRepository extends ListCrudRepository<Coffee,Integer> {

}
