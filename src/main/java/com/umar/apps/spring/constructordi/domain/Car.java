package com.umar.apps.spring.constructordi.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Engine engine;
    private Transmission transmission;

    @Autowired
    public Car(Engine engine, Transmission transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return String.format("""
                Car{engine=%s, transmission=%s}""", engine, transmission);
    }
}
