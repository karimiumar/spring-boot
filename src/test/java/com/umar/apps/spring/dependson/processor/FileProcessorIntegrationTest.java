package com.umar.apps.spring.dependson.processor;

import com.umar.apps.spring.dependson.config.TestConfig;
import com.umar.apps.spring.dependson.shared.File;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
public class FileProcessorIntegrationTest {

    @Autowired
    ApplicationContext ctx;

    @Autowired
    File file;

    @Test
    void whenAllBeansCreated_thenFileTextEndsWith_Processed() {
        ctx.getBean("fileProcessor");
        assertThat(file.getText()).endsWith("processed");
    }

    @Test
    public void whenDependentBeanNotAvailable_ThrowsNoSuchBeanDefinitionException(){
        assertThatThrownBy(() -> ctx.getBean("dummyFileProcessor"));
    }

    @Test
    public void whenCircularDependency_ThrowsBeanCreationException(){
        assertThatThrownBy(() -> ctx.getBean("dummyFileReaderCircular"));
    }
}
