package edu.hanoi.jazz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config.xml")
public class SpringHibernateApplication {

	public static void main(String[] args) {

//		SpringApplication.run(SpringHibernateApplication.class, args);
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringHibernateApplication.class);
		ctx.start();
	}

}
