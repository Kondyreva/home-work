package sbp.sbrf.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sbp.sbrf.example.annotations.TestAnnotationConfig;

import java.util.HashMap;

@ComponentScan(basePackages = "sbp.sbrf.example.annotations")
public class Main {
    public static void main(String[] args) {

        getClassPathXMLContext();
        getAnnotationConfigContext();

    }

    public static void getClassPathXMLContext(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");

        TestClassPathXml obj =  context.getBean("test", TestClassPathXml.class);

        String msg = obj.getMsg();

        System.out.println(msg);
    }

    public static void getAnnotationConfigContext(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);

        TestAnnotationConfig obj =  context.getBean("test", TestAnnotationConfig.class);

        String msg = obj.getMsg();

        System.out.println(msg);
    }
}
