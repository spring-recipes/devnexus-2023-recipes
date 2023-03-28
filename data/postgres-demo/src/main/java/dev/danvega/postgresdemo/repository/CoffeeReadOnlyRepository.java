package dev.danvega.postgresdemo.repository;

import dev.danvega.postgresdemo.model.Coffee;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CoffeeReadOnlyRepository extends Repository<Coffee,Integer> {

    List<Coffee> findAll();

    Optional<Coffee> findById(Integer id);

}
