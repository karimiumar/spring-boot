package com.umar.apps.spring.ditypes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleFormatter {

    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("di-types.xml");
        var article = ctx.getBean("articleWithSetterInjectionBean", ArticleWithSetterInjection.class);
        var formattedArticle = article.format("Format this text.");
        System.out.println(formattedArticle);
    }
}
