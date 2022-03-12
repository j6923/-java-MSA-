package com.my.first;
import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
public class LifeCycleServlet extends HttpServlet implements Servlet {
  
    public LifeCycleServlet() {
        super();
        // 객체생성시 자동호출됨. 
        System.out.println("생성자 호출됨 ");
//        ServletContext sc;
//        sc = this.getServletContext(); //NullPointerException발생 
//        String atxtRealPath = sc.getRealPath("a.txt"); 
//        System.out.println("a.txt파일의 실제경로:" + atxtRealPath);
        //first servlet이 가지고 있는 sc라는 변수가 null값인데 sc를 얻어올 떄 this.으로 가져와야 하는데 null이어서 null에러남. 
    }

	
	public void init(ServletConfig config) throws ServletException {
		//객체 생성시 자동호출됨 서블릿초기화 
		System.out.println("init() 호출됨");
		super.init(config); 
		ServletContext sc;
        sc = this.getServletContext(); 
        String atxtRealPath = sc.getRealPath("a.txt"); 
        System.out.println("a.txt파일의 실제경로:" + atxtRealPath);
       
		
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 요청할 때마다 자동호출됨. 
		System.out.println("service()호출됨");
	}
	
	public void destroy() {
		//객체소멸시 자동호출됨  
		System.out.println("destroy()호출됨");
		
	}
}
