package edu.java.model;

public class B {
    int b;
    B(){System.out.println("b is created");}
    void print(){System.out.println("hello b");}

    public void setB(int b) {
        System.out.println("Call from setter b");
        this.b = b;
    }

    public int getB() {
        return b;
    }
}
