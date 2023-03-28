package dev.danvega.javabucks.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record Coffee(
        Integer id,
        @NotEmpty
        String name,
        Size size,
        @Max(10)
        BigDecimal price,
        BigDecimal cost) {
}