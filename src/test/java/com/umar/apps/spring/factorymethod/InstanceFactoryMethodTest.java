package com.umar.apps.spring.factorymethod;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class InstanceFactoryMethodTest {

    static ApplicationContext ctx;

    @BeforeAll
    static void setup() {
        ctx = new ClassPathXmlApplicationContext("factory-method.xml");
    }

    @Test
    void givenFactoryBeanFactoryMethodContext_whenGetBeanDefinitionCount_thenShouldReturn4() {
        assertThat(ctx.getBeanDefinitionCount()).isEqualTo(4);
        assertThat(ctx.getBeanDefinitionNames()).containsExactly("fooFactory", "foo", "barFactory", "bar");
    }

    @Test
    void givenFactoryBeanFactoryMethod_whenCreateInstance_thenInstanceIsNotNull() {
        var instance = ctx.getBean("foo");
        assertThat(instance).isNotNull();
        assertThat(instance).hasToString("Foo{}");
    }

    @Test
    void givenFactoryBeanFactoryMethod_whenCreateInstanceWithArgs_thenInstanceIsNotNull() {
        var instance = ctx.getBean("bar");
        assertThat(instance).isNotNull();
        assertThat(instance).hasToString("Bar{bar=bar}");
    }
}
