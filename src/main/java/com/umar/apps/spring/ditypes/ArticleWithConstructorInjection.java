package com.umar.apps.spring.ditypes;

import org.springframework.beans.factory.annotation.Autowired;

public class ArticleWithConstructorInjection {

    private TextFormatter textFormatter;

    @Autowired
    public ArticleWithConstructorInjection(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public String format(String text) {
        return textFormatter.format(text);
    }
}
