package dev.danvega.javabucksrest.controller;

import dev.danvega.javabucksrest.model.Coffee;
import dev.danvega.javabucksrest.model.Size;
import dev.danvega.javabucksrest.repository.CoffeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CoffeeController.class)
class CoffeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CoffeeRepository coffeeRepository;

    @Test
    void findAllShouldReturn200Status() throws Exception {
        Coffee coffee = new Coffee(null,"TEST", Size.TALL);
        given(coffeeRepository.findAll()).willReturn(List.of(coffee));
        mvc.perform(get("/api/coffee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*",hasSize(1)));
    }

}