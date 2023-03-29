package dev.danvega.countries.model;

import org.springframework.data.annotation.Id;

public record Country(
        @Id
        Integer id,
        String name,
        String emoji,
        String currency,
        String code,
        String capital
) {
}
