package edu.hanoi.jazz.springhibernate;

import edu.hanoi.jazz.SpringHibernateApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringHibernateApplication.class);
	}

}
