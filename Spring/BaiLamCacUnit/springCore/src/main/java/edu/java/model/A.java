package edu.java.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class A {
    private String message;
    @Autowired(required = false)
    @Qualifier("b3")
    private B b;

    public A() {
        System.out.println("a is created");
    }

    public A(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    void print() {
        System.out.println("hello a");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void display() {
        System.out.println(message);
        b.print();
        System.out.println(b.getB());
    }
}