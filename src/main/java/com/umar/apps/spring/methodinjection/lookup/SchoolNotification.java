package com.umar.apps.spring.methodinjection.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component("schoolNotification")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SchoolNotification {

    @Autowired Grader grader;

    private final String name;
    private final Collection<Integer> marks;

    public SchoolNotification(String name) {
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public String addMark(Integer mark) {
        marks.add(mark);
        return grader.grade(marks);
    }

    public Collection<Integer> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }
}
