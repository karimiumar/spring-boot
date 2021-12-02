package com.umar.apps.spring.methodinjection.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("studentService")
public abstract class StudentServices {

    private final Map<String, SchoolNotification> notes = new HashMap<>();

    /*
        We can sometimes make the @Lookup-annotated method abstract, like below.
        Using abstract is a bit nicer-looking than a stub, but we can only use it when
        we use @Bean-manage the surrounding bean.
        An annotation that indicates 'lookup' methods, to be overridden by the container to redirect them back to the BeanFactory for a getBean call.
     */
    @Lookup
    protected abstract SchoolNotification getNotification(String name);

    public String appendMark(String name, Integer mark) {
        var notification = notes.computeIfAbsent(name, exists -> getNotification(name));
        return notification.addMark(mark);
    }
}
