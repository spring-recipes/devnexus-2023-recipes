package dev.danvega.http;

import dev.danvega.http.client.CoffeeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CoffeeClient coffeeClient() {
	    WebClient client = WebClient.builder()
				.baseUrl("https://coffee.alexflipnote.dev")
				.build();
	    HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(client))
				.build();
	    return factory.createClient(CoffeeClient.class);
	}

}
