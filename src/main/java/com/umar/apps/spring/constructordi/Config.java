package com.umar.apps.spring.constructordi;

import com.umar.apps.spring.constructordi.domain.Engine;
import com.umar.apps.spring.constructordi.domain.Transmission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.umar.apps.spring.constructordi")
public class Config {

    @Bean
    public Engine engine(){
        return Engine.of("V8", 5);
    }

    @Bean
    public Transmission transmission() {
        return Transmission.of("sliding");
    }
}
