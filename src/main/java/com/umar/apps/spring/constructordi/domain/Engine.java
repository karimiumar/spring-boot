package com.umar.apps.spring.constructordi.domain;

import java.util.Objects;

public record Engine(String type, Integer volume) {

    public Engine {
        Objects.requireNonNull(type, "type is required");
        Objects.requireNonNull(volume, "volume is required");
    }

    public static Engine of(String type, Integer volume) {
        return new Engine(type, volume);
    }
}
