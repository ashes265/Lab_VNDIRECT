package edu.java.spring.jdbc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcDAO {
    private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);
    private static DataSource dataSource;
    private static String insertQuery;
    private static JdbcTemplate jdbcTemplate;
    private String updateAgeByNameSQL;

    private String deleteStudent;

    @Autowired
    private PlatformTransactionManager transactionManager;

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

    private void createTableIfNotExist() throws SQLException {
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "STUDENT", null);
        if (rs.next()) {
            LOGGER.info("Table " + rs.getString("TABLE_NAME") + " already exists!");
            return;
        }

        jdbcTemplate.execute("CREATE TABLE STUDENT(" + " id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," + " name VARCHAR(1000)," + " age INTEGER)");
    }

    public int[] add(List<Student> students) {
        List<Object[]> batch = new ArrayList<>();
        students.forEach(student -> batch.add(new Object[]{student.getName(), student.getAge()}));
        return jdbcTemplate.batchUpdate(insertQuery, batch);
    }

    public List<Student> loadStudent(String name) {
        return jdbcTemplate.query("SELECT * FROM STUDENT WHERE NAME LIKE '%" + name + "%'", new StudentRowMapper());
    }

    public void insert(String name, int age) {
        jdbcTemplate.update(insertQuery, name, age);
        LOGGER.info("Create Record Name= " + name + " Age = " + age);
    }

    public void updateAgeByName(String name, int age, int oldAge) {
        jdbcTemplate.update(updateAgeByNameSQL, age, name, oldAge);
        LOGGER.info("Update Student " + name + " Age = " + age);
    }

    public void deleteStudentByName(String name, int age) {
        jdbcTemplate.update(deleteStudent, name, age);
        LOGGER.info("Delete Student " + name + " Age " + age);
    }

    public int totalRecord() {
        return jdbcTemplate.execute(new StatementCallback<Integer>() {
            @Override
            public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
                ResultSet rs = statement.executeQuery("select count(*) from student");
                return rs.next() ? rs.getInt(1) : 0;
            }
        });
    }

    public void save(Object name, Object age) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        String countQuery = "select count(*) from student";
        try {
            Integer total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("Before rollback, total record is: " + total);
            String sql="insert into Student(name,age) values(?,?)";
            jdbcTemplate.update(sql,name,age);
            total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("After save data, total record is: " + total);
            String countQuery2="select count(* from STUDENT";
            total = jdbcTemplate.queryForObject(countQuery2, Integer.class);
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            Integer total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("After rollback, total record is: " + total);
        }
    }

    public void setDataSource(DataSource dataSource) {
        StudentJdbcDAO.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public static Logger getLOGGER() {
        return LOGGER;
    }

    public static void setLOGGER(Logger LOGGER) {
        StudentJdbcDAO.LOGGER = LOGGER;
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getUpdateAgeByNameSQL() {
        return updateAgeByNameSQL;
    }

    public void setUpdateAgeByNameSQL(String updateAgeByNameSQL) {
        this.updateAgeByNameSQL = updateAgeByNameSQL;
    }


    public static String getInsertQuery() {
        return insertQuery;
    }


    public static void setInsertQuery(String insertQuery) {
        StudentJdbcDAO.insertQuery = insertQuery;
    }

    public String getDeleteStudent() {
        return deleteStudent;
    }

    public void setDeleteStudent(String deleteStudent) {
        this.deleteStudent = deleteStudent;
    }


}
