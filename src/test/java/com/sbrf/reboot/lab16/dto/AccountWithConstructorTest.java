package com.sbrf.reboot.lab16.dto;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class AccountWithConstructorTest {

    @Test
    public void getAccount() {
        ApplicationContext xmlContext =
                new ClassPathXmlApplicationContext("context.xml");

        Account account = xmlContext.getBean(Account.class);

        assertEquals(10.23,account.getBalance(), 0.001);
        assertEquals("USD",account.getCurrency());
    }
}