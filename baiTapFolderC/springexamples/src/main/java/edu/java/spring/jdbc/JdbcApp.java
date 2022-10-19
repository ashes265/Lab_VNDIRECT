package edu.java.spring.jdbc;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcApp {
    public static void main(String[] args) {
        Logger LOGGER=Logger.getLogger(JdbcApp.class);
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc=(StudentJdbcDAO) context.getBean("studentJdbcDAO");
        System.out.println("Created bean "+jdbc);
        jdbc.insert("Tran Van O", 24);
        LOGGER.info("Total Students is "+jdbc.totalRecord());
        jdbc.loadStudent("Tran").forEach(student->LOGGER.info(student));
        jdbc.updateAgeByName("Tran Van A",24,60);
        jdbc.deleteStudentByName("Tran Van O", 24);
        jdbc.loadStudent("Tran").forEach(student->LOGGER.info(student));
        List<Student> students=new ArrayList<>();
        students.add(new Student("Phung Duc Hai",18));
        students.add(new Student("Tran Quang Trung", 21));
        students.add(new Student("Truong Xuan Trinh",12));
        int[]values=jdbc.add(students);
        for (int i = 0; i < values.length; i++) {
            LOGGER.info("Add record "+i+" : "+(values[i]==0?"failed":"success"));
        }
        LOGGER.info("Total students is "+jdbc.totalRecord());
        System.out.println("\n=========================PAGE 16 --->====================\n");
        jdbc.save("Tran Thi A","23");
    }
}
