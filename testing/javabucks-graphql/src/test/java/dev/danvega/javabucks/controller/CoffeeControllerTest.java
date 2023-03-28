package dev.danvega.javabucks.controller;

import dev.danvega.javabucks.model.Coffee;
import dev.danvega.javabucks.model.Size;
import dev.danvega.javabucks.service.CoffeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@GraphQlTest(CoffeeController.class)
class CoffeeControllerTest {

    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private CoffeeService coffeeService;

    private List<Coffee> coffees = new ArrayList<>();

    @BeforeEach
    void setUp() {
        coffees.add(new Coffee(1, "Caffè Americano", Size.GRANDE));
        coffees.add(new Coffee(2, "Caffè Latte", Size.VENTI));
        coffees.add(new Coffee(3, "Caffè Caramel Macchiato", Size.TALL));
    }


    @Test
    void findAll() {
        // language=GraphQL
        String document = """
        query {
            findAll {
                id
                name
                size                
            }
        }
        """;

        when(coffeeService.findAll()).thenReturn(coffees);

        graphQlTester.document(document)
                .execute()
                .path("findAll")
                .entityList(Coffee.class)
                .hasSize(3);
    }

    @Test
    void findOne() {
        // language=GraphQL
        String document = """
        query findOne($id: ID){
            findOne(id: $id) {
                id
                name
                size                
            }
        }
        """;

        when(coffeeService.findOne(1)).thenReturn(Optional.of(coffees.get(0)));

        graphQlTester.document(document)
                .variable("id",1)
                .execute()
                .path("findOne")
                .entity(Coffee.class)
                .satisfies(coffee -> {
                    assertEquals("Caffè Americano",coffee.name());
                    assertEquals(Size.GRANDE,coffee.size());
                });

    }

}