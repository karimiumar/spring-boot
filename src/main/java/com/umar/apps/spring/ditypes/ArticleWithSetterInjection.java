package com.umar.apps.spring.ditypes;

import org.springframework.beans.factory.annotation.Autowired;

public class ArticleWithSetterInjection {

    private TextFormatter textFormatter;

    public ArticleWithSetterInjection(TextFormatter formatter) {
        textFormatter = formatter;
    }


    @Autowired
    public void setTextFormatter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public String format(String text) {
        return textFormatter.format(text);
    }
}
