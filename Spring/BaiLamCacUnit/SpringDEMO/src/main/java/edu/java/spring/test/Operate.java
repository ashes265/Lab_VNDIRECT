package edu.java.spring.test;

import edu.java.spring.model.ClassP;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Operate {
    public static void main(String[] args) {
        Resource r=new ClassPathResource("beans-servlet.xml");
        BeanFactory factory=new XmlBeanFactory(r);
        ClassP forClass = (ClassP) factory.getBean("class");
        forClass.displayInfo();
    }
}
