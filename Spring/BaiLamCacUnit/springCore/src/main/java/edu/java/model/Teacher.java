package edu.java.model;

public class Teacher extends Person{
    private int mgv;
    private String school;
    public Teacher(){

    }

    public Teacher(int mgv, String school) {
        this.mgv = mgv;
        this.school = school;
    }

    public Teacher(String name, int age, int mgv, String school) {
        super(name, age);
        this.mgv = mgv;
        this.school = school;
    }

    public int getMgv() {
        return mgv;
    }

    public void setMgv(int mgv) {
        this.mgv = mgv;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return super.toString()+"\n MGV: "+mgv+"\n School: "+school;
    }
}
