package dev.danvega.postgresdemo.repository;

import dev.danvega.postgresdemo.model.Coffee;
import org.springframework.data.repository.ListCrudRepository;

public interface CoffeeRepository extends ListCrudRepository<Coffee,Integer> {

    // additional methods

}
