package com.umar.apps.spring.ditypes.model;

public abstract class Vehicle {

    private String name;
    private String manufacturer;

    public Vehicle(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
