package edu.java.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        //        context.registerShutdownHook();
        //        context.start();
        //        HelloClazz obj = (HelloClazz) context.getBean("helloJavaClazz");
        //        obj.printMessage();
        //        System.out.println(obj);
        //
        //        HelloClazz obj2=(HelloClazz)context.getBean("helloJavaClazz2");
        //        obj2.printMessage();
        //        System.out.println(obj2);
        //        System.out.println(obj==obj2);

        //        HelloWorld obj3= (HelloWorld) context.getBean("helloWorld");
        //        obj3.sayHello();
        //        HelloClazz obj = (HelloClazz) context.getBean("helloJavaClazz");
        //        obj.printMessage();
        //        System.out.println(obj);

        //        JavaClazz clazz= (JavaClazz) context.getBean("jee01");
        //        System.out.println("Map implement is "+clazz.getStudents().getClass());
        //        System.out.println("There are "+clazz.getStudents().size()+" student in the class");

        //        HelloClazz clazz2= (HelloClazz) context.getBean("helloJavaClazz");
        //        System.out.println("Total classes is "+clazz2.getClazzes().size());

        //        HelloWorld page32= (HelloWorld) context.getBean("helloWorld");
        //        page32.sayHello();
        //        HelloClazz page32Clazz= (HelloClazz) context.getBean("clazz");
        //        page32Clazz.printMessage();

        //        HelloClazz page34= (HelloClazz) context.getBean("helloJavaClazz2");
        //        page34.printMessage();

        //        HelloWorld page35=(HelloWorld) context.getBean("helloWorld");
        //        page35.sayHello();

        //        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //        HelloClazz obj=(HelloClazz) context.getBean("helloJavaClazz");
        //        obj.printMessage();
        //        System.out.println(obj);
        //
        //        HelloClazz obj2=(HelloClazz) context.getBean("helloJavaClazz");
        //        obj2.printMessage();
        //        System.out.println(obj2);
        //
        //        //check true false
        //        System.out.println(obj2==obj);

        //Page 18
        System.out.println("\n===========================\nPage18 ->\n===========================\n");
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("beans.xml");
        context2.registerShutdownHook();
        context2.start();
        context2.stop();

        //        HelloWorld page24= (HelloWorld) context2.getBean("helloWorld");
        //        page24.sayHello();
        //        System.out.println("\n===========================\nPage30 ->\n===========================\n");
        //        JavaClazz clazz= (JavaClazz) context2.getBean("jee01");
        //        System.out.println("Map Implement is: "+clazz.getStudents().getClass());
        //        System.out.println("There are "+clazz.getStudents().size()+" in the class");
        //        HelloClazz page30= (HelloClazz) context2.getBean("helloJavaClazz");
        //        System.out.println("Total classes is "+page30.getClazzes().size());
        System.out.println("\n===========================\nPage32 ->\n===========================\n");
        HelloWorld page32 = (HelloWorld) context2.getBean("helloWorld");
        page32.sayHello();

    }

}

