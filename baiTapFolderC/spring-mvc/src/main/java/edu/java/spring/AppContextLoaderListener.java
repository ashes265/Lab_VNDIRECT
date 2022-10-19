package edu.java.spring;

import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

public class AppContextLoaderListener extends ContextLoaderListener {
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("==========> DA HUY UNG DUNG");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("==========> DA KHOI TAO UNG DUNG");
    }
}
