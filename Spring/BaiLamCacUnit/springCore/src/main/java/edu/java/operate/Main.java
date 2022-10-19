package edu.java.operate;

import edu.java.model.A;
import edu.java.model.Class;
import edu.java.model.Question;
import edu.java.model.Teacher;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {
//        Resource r=new ClassPathResource("applicationContext.xml");
//        BeanFactory factory=new XmlBeanFactory(r);
//        Class forClass=(Class)factory.getBean("forClass");
//        System.out.println(forClass);
//        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        A a= (A) context.getBean("a");
        a.display();
    }
}
