package com.umar.apps.spring.factorymethod;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class StaticFactoryMethodTest {

    static ApplicationContext ctx;

    @BeforeAll
    static void setup() {
        ctx = new ClassPathXmlApplicationContext("static-factory-method.xml");
    }

    @Test
    void givenFactoryMethodContext_whenGetBeanDefinitionCount_thenShouldReturn2() {
        assertThat(ctx.getBeanDefinitionCount()).isEqualTo(2);
        //exactly as defined in factory-method.xml
        assertThat(ctx.getBeanDefinitionNames()).containsExactly("staticFoo", "staticBar");
    }

    @Test
    void givenFactoryMethod_whenGetInstance_thenInstanceIsNotNull() {
        var instance = ctx.getBean("staticFoo");
        assertThat(instance).isNotNull();
        assertThat(instance).hasToString("Foo{}");
    }

    @Test
    void givenFactoryMethod_whenGetInstanceWithArgs_thenInstanceIsNotNull() {
        var instance = ctx.getBean("staticBar");
        assertThat(instance).isNotNull();
        assertThat(instance).hasToString("Bar{bar=static-bar}");
    }
}
