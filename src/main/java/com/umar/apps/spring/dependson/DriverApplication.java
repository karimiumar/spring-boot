package com.umar.apps.spring.dependson;

import com.umar.apps.spring.dependson.config.Config;
import com.umar.apps.spring.dependson.file.processor.FileProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DriverApplication {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        ctx.getBean(FileProcessor.class);
        ctx.close();
    }
}
