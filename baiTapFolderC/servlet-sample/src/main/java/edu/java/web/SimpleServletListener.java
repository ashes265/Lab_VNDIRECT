package edu.java.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SimpleServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("\n\n Servet Context destroyed");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("\n\n Servet Context started");
    }
}
