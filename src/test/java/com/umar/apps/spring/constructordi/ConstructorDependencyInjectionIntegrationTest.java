package com.umar.apps.spring.constructordi;

import com.umar.apps.spring.constructordi.domain.Car;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = Config.class)
public class ConstructorDependencyInjectionIntegrationTest {

    @Test
    void givenPrototypeInjection_whenObjectFactory_thenReturnNewInstance() {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        var firstCar = ctx.getBean(Car.class);

        var xmlCtx = new ClassPathXmlApplicationContext("constructordi.xml");
        var secondCar = xmlCtx.getBean(Car.class);

        assertThat(firstCar).isNotSameAs(secondCar);
        assertThat(firstCar).hasToString("Car{engine=Engine[type=V8, volume=5], transmission=Transmission[type=sliding]}");
        assertThat(secondCar).hasToString("Car{engine=Engine[type=V4, volume=2], transmission=Transmission[type=sliding]}");
    }
}
