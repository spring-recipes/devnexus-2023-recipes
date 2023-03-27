package dev.danvega.http.model;

import java.util.Random;

public record Coffee(Integer id, String file) {
    public Coffee {
        if (id == null) {
            id = new Random().nextInt(100);
        }
    }
}
