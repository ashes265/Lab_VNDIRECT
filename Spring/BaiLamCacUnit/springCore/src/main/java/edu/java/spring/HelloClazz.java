package edu.java.spring;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

public class HelloClazz implements DisposableBean {
    private String message;

    private List<JavaClazz> clazzes;
    public HelloClazz() {
        message = "From Constructor: Say hello every one!";
    }

    public HelloClazz(int person) {
        message = "From Constructor: Say hello to " + person + " persons!";
    }

    public HelloClazz(HelloClazz clazz) {
        message = clazz.message;
    }

    public String getMessage() {
        return message;
    }

    public List<JavaClazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<JavaClazz> clazzes) {
        this.clazzes = clazzes;
    }

    public void setMessage(String message) {
        this.message = "Call from setter: "+message;
    }

    public void printMessage() {
        System.out.println("Your Message: " + message);
    }

    private void release() {
        message = null;
        System.out.println("Message is null");
    }

    private void initMessage() {
        System.out.println("Calling init method....");
        message = "From init method: Say hello bean!";
    }

    @Override
    public void destroy() throws Exception {
        message = null;
        System.out.println("Message is null");
    }


}
