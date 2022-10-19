package edu.java.spring.model;

import org.springframework.beans.factory.annotation.Qualifier;

public class Student {
    private int id;
    private String name;
    University university;

    public Student() {

    }

    public Student(int id, String name, University university) {
        this.id = id;
        this.name = name;
        this.university = university;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", university=" + university +
                '}';
    }
}
