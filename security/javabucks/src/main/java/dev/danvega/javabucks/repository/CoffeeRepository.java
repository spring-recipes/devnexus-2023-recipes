package dev.danvega.javabucks.repository;

import dev.danvega.javabucks.model.Coffee;
import org.springframework.data.repository.ListCrudRepository;

public interface CoffeeRepository extends ListCrudRepository<Coffee,Integer> {

}
