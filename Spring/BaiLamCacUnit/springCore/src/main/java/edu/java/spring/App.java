package edu.java.spring;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Logger logger= Logger.getLogger(App.class);

//        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//        HelloClazz obj=(HelloClazz) context.getBean("helloJavaClazz");
//        obj.printMessage();
//        System.out.println(obj);
//        HelloClazz obj2=(HelloClazz) context.getBean("helloJavaClazz");
//        obj2.printMessage();
//        System.out.println(obj2);
//        System.out.println(obj==obj2);


//        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//        context.registerShutdownHook();
//        HelloClazz obj=(HelloClazz) context.getBean("helloJavaClazz");
//        obj.printMessage();
//        System.out.println(obj);
//        HelloClazz obj2 = (HelloClazz) context.getBean("helloJavaClazz");
//        obj2.printMessage();
//        System.out.println(obj2);
//        System.out.println(obj == obj2);

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//       HelloClazz bean= (HelloClazz) context.getBean("helloJavaClazz");
        context.start();
        HelloWorld bean2= (HelloWorld) context.getBean("helloWorld");
        bean2.sayHello();
        context.stop();
//        bean.printMessage();

//        JavaClazz clazz= (JavaClazz) context.getBean("jee01");
//        logger.info("Map implements is "+clazz.getStudents().getClass());
//        logger.info("There are "+clazz.getStudents().size()+" in the class");


//        HelloClazz clazz= (HelloClazz) context.getBean("helloJavaClazz");
//        logger.info("Total classes is "+clazz.getClazzes().size());
    }

}
