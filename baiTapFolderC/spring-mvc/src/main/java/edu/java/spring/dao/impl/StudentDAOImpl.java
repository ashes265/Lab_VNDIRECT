package edu.java.spring.dao.impl;

import edu.java.spring.controller.Student;
import edu.java.spring.dao.StudentDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO, DisposableBean {
    private static Logger LOGGER = Logger.getLogger(StudentDAOImpl.class);
    private static DataSource dataSource;
    private static JdbcTemplate jdbcTemplate;
    private String deleteStudent;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.dataSource=dataSource;
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }
    @PostConstruct
    private void createTableIfNotExist() throws SQLException {
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "STUDENT", null);
        if (rs.next()) {
            LOGGER.info("Table " + rs.getString("TABLE_NAME") + " already exists!");
            return;
        }
        jdbcTemplate.execute("CREATE TABLE STUDENT(" + " id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," + " name VARCHAR(1000)," + " age INTEGER)");
    }

    @Override
    public void insert(Student student) throws SQLException {
//        JdbcTemplate
        DatabaseMetaData dbmd=dataSource.getConnection().getMetaData();
        jdbcTemplate.update("INSERT INTO STUDENT(name,age) VALUES(?,?)",student.getName(),student.getAge());
        LOGGER.info("Created Record Name = "+student.getName());
    }

    private final static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int i) throws SQLException {
            try {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            } catch (Exception exp) {
                LOGGER.error(exp);
                return null;
            }
        }
    }
    @Override
    public void delete(int id) {
        jdbcTemplate.execute("DELETE FROM STUDENT WHERE ID="+id);
    }

    @Override
    public void update(Student student) {
        jdbcTemplate.update("UPDATE STUDENT SET NAME=? WHERE ID=?",student.getName(),student.getId());
    }

    @Override
    public Student get(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM STUDENT WHERE ID="+id, new StudentRowMapper());
    }

    @Override
    public List<Student> list() {
        return jdbcTemplate.query("SELECT * FROM STUDENT", new StudentRowMapper());
    }

    public void setDeleteStudent(String deleteStudent) {
        this.deleteStudent = deleteStudent;
    }

    public String getDeleteStudent() {
        return deleteStudent;
    }

    @Override
    public void destroy() throws Exception {
        DriverManager.getConnection("jdbc:derby:C:/Java/sampledb2;shutdown=true");
    }

    @Override
    public List<Student> listStudent(String filter){
        return jdbcTemplate.query("SELECT * FROM STUDENT WHERE NAME LIKE '%"+filter+"%'",new StudentRowMapper());
    }
}
