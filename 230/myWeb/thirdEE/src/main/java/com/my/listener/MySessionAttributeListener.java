package com.my.listener;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class MySessionAttributeListener
 *
 */
public class MySessionAttributeListener implements HttpSessionAttributeListener {
	private int loginedCount; //로그인한 사용자수

    /**
     * Default constructor. 
     */
    public MySessionAttributeListener() {
        // TODO Auto-generated constructor stub
    }
    
    public void attributeAdded(HttpSessionBindingEvent ev) {
    	HttpSession session = ev.getSession();
    	String evName = ev.getName();
    	if(evName.equals("loginInfo")) {
    		loginedCount++;
    		System.out.println("로그인된 사용자수:" + loginedCount);
    	}
    }
	
    public void attributeRemoved(HttpSessionBindingEvent ev) {
    	String evName = ev.getName();
    	if(evName.equals("loginInfo")) {
    		loginedCount--;
    		System.out.println("로그인된 사용자수:" + loginedCount);
    		
    	}
    }
}
