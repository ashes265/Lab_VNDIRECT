package edu.hanoi;

import edu.hanoi.controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
@ComponentScan(basePackages = "edu.*")
public class SpringClazzApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringClazzApplication.class, args);
    }
}
