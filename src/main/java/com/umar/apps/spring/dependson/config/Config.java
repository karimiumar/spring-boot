package com.umar.apps.spring.dependson.config;

import com.umar.apps.spring.dependson.file.processor.FileProcessor;
import com.umar.apps.spring.dependson.file.reader.FileReader;
import com.umar.apps.spring.dependson.file.writer.FileWriter;
import com.umar.apps.spring.dependson.shared.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.umar.apps.spring.dependson")
public class Config {

    @Autowired
    File file;

    @Bean("fileProcessor")
    @DependsOn({"fileReader", "fileWriter"})
    @Lazy
    public FileProcessor fileProcessor() {
        return new FileProcessor(file);
    }

    @Bean("fileReader")
    public FileReader fileReader() {
        return new FileReader(file);
    }

    @Bean("fileWriter")
    public FileWriter fileWriter() {
        return new FileWriter(file);
    }
}
