package com.umar.apps.spring.dependson.config;


import com.umar.apps.spring.dependson.file.processor.FileProcessor;
import com.umar.apps.spring.dependson.file.reader.FileReader;
import com.umar.apps.spring.dependson.file.writer.FileWriter;
import com.umar.apps.spring.dependson.shared.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.umar.apps.spring.dependson")
public class TestConfig {

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

    @Bean("dummyFileProcessor")
    @DependsOn({"dummyFileWriter"})
    @Lazy
    public FileProcessor dummyFileProcessor() {
        return new FileProcessor(file);
    }

    @Bean("dummyFileProcessorCircular")
    @DependsOn({"dummyFileReaderCircular"})
    @Lazy
    public FileProcessor dummyFileProcessorCircular() {
        return new FileProcessor(file);
    }

    @Bean("dummyFileReaderCircular")
    @DependsOn({"dummyFileProcessorCircular"})
    @Lazy
    public FileReader dummyFileReaderCircular() {
        return new FileReader(file);
    }

}
