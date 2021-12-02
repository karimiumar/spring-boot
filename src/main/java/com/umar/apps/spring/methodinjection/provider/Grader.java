package com.umar.apps.spring.methodinjection.provider;

import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class Grader {

    public String grade(Collection<Integer> marks) {
        boolean result = marks.stream().anyMatch(mark -> mark > 45);
        return result ? "PASS" : "FAIL";
    }
}
