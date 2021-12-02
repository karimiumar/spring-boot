package com.umar.apps.spring.methodinjection.provider;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

public class SchoolNotification {

    @Autowired
    Grader grader;

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
