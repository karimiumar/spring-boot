package com.umar.apps.spring.factorymethod.instance;

public class Bar {

    private final String bar;

    public Bar(String bar) {
        this.bar = bar;
    }

    @Override
    public String toString() {
        return String.format("""
                Bar{bar=%s}""", bar);
    }
}
