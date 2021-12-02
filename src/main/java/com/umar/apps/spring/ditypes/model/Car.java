package com.umar.apps.spring.ditypes.model;

public class Car extends Vehicle{

    private String engineType;

    public Car(String name, String manufacturer, String engineType) {
        super(name, manufacturer);
        this.engineType = engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engineType='" + engineType + '\'' +
                '}';
    }
}
