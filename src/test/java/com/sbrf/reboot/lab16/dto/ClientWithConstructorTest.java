package com.sbrf.reboot.lab16.dto;

import com.sbrf.reboot.lab16.Main;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class ClientWithConstructorTest {

    @Test
    public void getClient() {
        ApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(Main.class);

        ClientWithConstructor clientWithConstructor = annotationContext.getBean(ClientWithConstructor.class);

        Integer expected = 30;
        assertEquals(expected, clientWithConstructor.getClient().getAge());
        assertEquals("Jon", clientWithConstructor.getClient().getName());
    }
}