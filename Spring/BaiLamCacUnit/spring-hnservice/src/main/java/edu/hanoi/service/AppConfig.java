package edu.hanoi.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableWebMvc
@PropertySource("classpath:/application.properties")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private org.springframework.core.env.Environment env;

    private final static Logger lg = Logger.getLogger(AppConfig.class);


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        super.configureDefaultServletHandling(configurer);
        lg.info("start at "+dataSource());
        try {
            createTable("HN_GROUP", "create table HN_GROUP(id bigint primary "
                    + " key generated always as identity(start with 1, increment by 1),"
                    + " name varchar(100))");
            createTable("HN_USER", "create table HN_USER(username VARCHAR(100) primary key, "
                    + " password varchar(100),"
                    + " email varchar(100),"
                    + " age Integer,"
                    + " groupId bigint,"
                    + " CONSTRAINT GROUP_FK FOREIGN KEY(groupId) REFERENCES HN_GROUP(id))");
        } catch (Exception ex) {
           lg.error(ex, ex);
        }
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(env.getProperty("jdbc.url"));
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("edu.hanoi.service.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties pro = new Properties();
        pro.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        pro.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        return pro;

    }

    private void createTable(String name, String script) throws SQLException {
        DatabaseMetaData dbmd = dataSource().getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null, null, name, null);
        if (rs.next()) {
            lg.info("Table " + rs.getString("TABLE_NAME") + " already exists!");
            return;
        }
        dataSource().getConnection().createStatement().executeUpdate(script);
    }
}
