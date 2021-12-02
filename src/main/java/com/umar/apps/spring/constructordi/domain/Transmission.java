package com.umar.apps.spring.constructordi.domain;

import java.util.Objects;

public record Transmission(String type) {

    public Transmission {
        Objects.requireNonNull(type, "type is required");
    }

    public static Transmission of(String type) {
        return new Transmission(type);
    }
}
