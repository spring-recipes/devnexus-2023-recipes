package dev.danvega.countries.service;

import dev.danvega.countries.model.Country;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CountryService {

    private HttpGraphQlClient graphQlClient;

    public CountryService() {
        WebClient client = WebClient.builder()
                .baseUrl("https://countries.trevorblades.com")
                .build();
        graphQlClient = HttpGraphQlClient.builder(client).build();
    }


    public Mono<List<Country>> getCountries() {
        //language=GraphQL
        String document = """
            query {
              countries {
                name
                emoji
                currency
                code
                capital
              }
            }
        """;

        Mono<List<Country>> countries = graphQlClient.document(document)
                .retrieve("countries")
                .toEntityList(Country.class);

        return countries;
    }
}
