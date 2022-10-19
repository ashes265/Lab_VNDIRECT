package edu.java.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Class {
    private int classId;
    @Autowired(required = true)
    @Qualifier("per2")
    private Person per;
    public Class(){

    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Person getPer() {
        return per;
    }

    public void setPer(Person per) {
        this.per = per;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", per=" + per +
                '}';
    }
}
