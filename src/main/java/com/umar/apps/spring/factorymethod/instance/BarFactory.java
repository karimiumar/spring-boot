package com.umar.apps.spring.factorymethod.instance;

public class BarFactory {

    public Bar createInstance(String bar) {
        return new Bar(bar);
    }
}
