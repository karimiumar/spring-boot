package com.umar.apps.spring.ditypes.config;

import com.umar.apps.spring.ditypes.annotation.CarQualifier;
import com.umar.apps.spring.ditypes.model.Car;
import com.umar.apps.spring.ditypes.model.CarHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.umar.apps.spring.ditypes.model")
public class Config {

    @Bean
    @CarQualifier
    public Car getMercedes() {
        return new Car("E280", "Mercedes", "Diesel");
    }

    @Bean
    @CarQualifier
    public Car getBMW() {
        return new Car("M5", "BMW", "Petrol");
    }

    public static void main(String[] args) throws NoSuchFieldException{
        var ctx = SpringApplication.run(Config.class);
        var carHandler = ctx.getBean(CarHandler.class);
        carHandler.getVehicles().forEach(System.out::println);
    }
}
