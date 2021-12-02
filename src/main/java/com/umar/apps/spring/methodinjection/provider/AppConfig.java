package com.umar.apps.spring.methodinjection.provider;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.umar.apps.spring.methodinjection.provider")
public class AppConfig {

    @Bean("studentBean")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Student student() {
        return new Student();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SchoolNotification schoolNotification() {
        return new SchoolNotification("schoolNotification");
    }
}
