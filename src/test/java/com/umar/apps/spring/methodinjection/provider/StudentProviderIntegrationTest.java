package com.umar.apps.spring.methodinjection.provider;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentProviderIntegrationTest {

    @Test
    void whenLookupMethodCalled_thenNewInstanceReturned() {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //Student has Singleton Scope
        var student1 = ctx.getBean("studentBean", com.umar.apps.spring.methodinjection.provider.Student.class);
        var student2 = ctx.getBean("studentBean", com.umar.apps.spring.methodinjection.provider.Student.class);

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
}
