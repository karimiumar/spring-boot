package com.umar.apps.spring.dependson.shared;

import org.springframework.stereotype.Service;

@Service
public class File {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}