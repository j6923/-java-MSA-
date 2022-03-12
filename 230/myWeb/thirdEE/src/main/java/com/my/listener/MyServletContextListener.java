package com.my.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *
 */
public class MyServletContextListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent argO) {
		System.out.println("ServletContext객체생성됨");
	}

    /**
     * Default constructor. 
     */
    public void contextDestroyed(ServletContextEvent argO) {
       System.out.println("ServletContext객체 소멸됨");
    }
	
}
