package edu.java.spring;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {
    private final static Logger LOGGER = Logger.getLogger(HelloWorld.class);
    private String message;

    @Autowired(required = true)
    @Qualifier("helloJavaClazz2")
    private HelloClazz clazz;

    public HelloWorld() {

    }

    public HelloWorld(String name, HelloClazz clazz) {
        message = "From helloworld constructor: " + name + " : " + clazz.getMessage();
    }

    @Required
    public void setMessage(String message) {
        this.message = message;
    }

    public void sayHello() {
        clazz.printMessage();
        LOGGER.info("From HelloWorld: " + message);
    }

    public void setClazz(HelloClazz clazz) {
        this.clazz = clazz;
    }
}
