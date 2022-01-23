package com.sbrf.reboot.lab16;

import com.sbrf.reboot.lab16.dto.Account;
import com.sbrf.reboot.lab16.dto.ClientWithConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan(basePackages = "com.sbrf.reboot.lab16.dto")
public class Main {
    public static void main(String[] args) {

        getClassPathXMLContext();
        getAnnotationConfigContext();

    }

    public static void getClassPathXMLContext(){
        ApplicationContext xmlContext =
                new ClassPathXmlApplicationContext("context.xml");

        Account account = xmlContext.getBean(Account.class);

        System.out.println(account);
    }

    public static void getAnnotationConfigContext(){
        ApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(Main.class);

        ClientWithConstructor clientWithConstructor = annotationContext.getBean(ClientWithConstructor.class);

        System.out.println(clientWithConstructor.getClient());
    }
}
