package com.sbrf.reboot.lab16.dto;

import com.sbrf.reboot.lab16.Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class ClientWithConstructorTest {

    @Test
    public void getClient() {
        ApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(Config.class);

        ClientWithConstructor clientWithConstructor = annotationContext.getBean(ClientWithConstructor.class);

        assertEquals(Integer.valueOf(30), clientWithConstructor.getClient().getAge());
        assertEquals("Jon", clientWithConstructor.getClient().getName());
    }
}