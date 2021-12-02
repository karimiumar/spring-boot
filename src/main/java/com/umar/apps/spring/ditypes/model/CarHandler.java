package com.umar.apps.spring.ditypes.model;

import com.umar.apps.spring.ditypes.annotation.CarQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarHandler {

    @Autowired
    @CarQualifier
    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() throws NoSuchFieldException {
        var vehiclesType = ResolvableType.forField(getClass().getDeclaredField("vehicles"));
        System.out.println(vehiclesType);
        var type = vehiclesType.getGeneric();
        System.out.println(type);
        var clazz = type.resolve();
        System.out.println(clazz);
        return vehicles;
    }
}
