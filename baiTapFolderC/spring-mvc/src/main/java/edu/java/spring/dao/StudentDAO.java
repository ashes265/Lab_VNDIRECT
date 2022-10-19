package edu.java.spring.dao;

import edu.java.spring.controller.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    public void insert(Student student) throws SQLException;
    public List<Student> list();
    public void delete(int id);
    public void update(Student student);
    public Student get(int id);
    public List<Student> listStudent(String filter);
}
