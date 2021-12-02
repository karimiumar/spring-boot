package com.umar.apps.spring.methodinjection.lookup;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentLookupIntegrationTest {

    @Test
    void whenLookupMethodCalled_thenNewInstanceReturned() {
        var ctx = new AnnotationConfigApplicationContext(LookupAppConfig.class);
        //Student has Singleton Scope
        var student1 = ctx.getBean("studentBean", Student.class);
        var student2 = ctx.getBean("studentBean", Student.class);

        assertThat(student1).isEqualTo(student2);
        //SchoolNotification has prototype scope and is injected using @Lookup so
        //every time a new Prototype instance will be invoked
        var notification1 = student1.getNotification("Alex");
        var notification2 = student2.getNotification("Betty");
        var notification3 = student2.getNotification("Betty");
        assertThat(notification1).isNotEqualTo(notification2);
        assertThat(notification3).isNotEqualTo(notification2);
        ctx.close();
    }

    @Test
    void whenAbstractGetterMethodInjects_thenNewInstanceReturned() {
        var ctx = new ClassPathXmlApplicationContext("beans.xml");
        var services = ctx.getBean("studentService", StudentServices.class);

        assertThat(services.appendMark("Alex",70)).isEqualTo("PASS");
        assertThat(services.appendMark("Betty", 43)).isEqualTo("FAIL");
        assertThat(services.appendMark("Sara", 90)).isEqualTo("PASS");
        ctx.close();
    }
}
