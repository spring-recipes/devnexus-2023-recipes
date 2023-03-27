package dev.danvega.randomcoffeereactive.controller;

import dev.danvega.randomcoffeereactive.model.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/coffee")
public class CoffeeController {

    WebClient client = WebClient.create("https://coffee.alexflipnote.dev");

    @GetMapping("/random")
    public Mono<Coffee> random() {
        return client.get()
                .uri("/random.json")
                .retrieve()
                .bodyToMono(Coffee.class);
    }
}
