package dev.danvega.javabucksrest.model;

import org.springframework.data.annotation.Id;

public record Coffee(@Id Integer id, String name, Size size) {
}
