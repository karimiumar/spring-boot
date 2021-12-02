package com.umar.apps.spring.constructordi;

import com.umar.apps.spring.constructordi.domain.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRunner {

    public static void main(String[] args) {
        var toyota = getCarFromXml();
        System.out.println(toyota);


        toyota = getCarFromJavaConfig();
        System.out.println(toyota);
    }

    private static Car getCarFromJavaConfig() {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        return ctx.getBean(Car.class);
    }

    private static Car getCarFromXml() {
        var ctx = new ClassPathXmlApplicationContext("constructordi.xml");
        return ctx.getBean(Car.class);
    }
}
