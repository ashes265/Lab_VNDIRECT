package edu.java.spring.model;

import java.util.Iterator;
import java.util.List;

public class ClassP {
    private List<Student> students;
    private String major;

    public ClassP() {

    }

    public ClassP(List<Student> students, String major) {
        this.students = students;
        this.major = major;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void displayInfo() {
        Iterator<Student> itr=students.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
