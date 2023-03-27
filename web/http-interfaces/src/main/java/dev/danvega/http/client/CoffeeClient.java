package dev.danvega.http.client;

import dev.danvega.http.model.Coffee;
import org.springframework.web.service.annotation.GetExchange;

public interface CoffeeClient {

    @GetExchange("/random.json")
    Coffee random();

}
