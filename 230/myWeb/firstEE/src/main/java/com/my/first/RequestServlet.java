package com.my.first;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http://localhost:8888/firstEE/request 요청시    tValue변수값은 null
		//http://localhost:8888/firstEE/request?t= 요청시 tValue변수값은 반문자열 
		//http://localhost:8888/firstEE/request?t=a 요청시 tValue변수값은 a 
		String tValue = request.getParameter("t");
		System.out.println(tValue);
		String pValue = request.getParameter("p");
		//http://localhost:8888/firstEE/request?c=a&c=b&c=d 
		//http://localhost:8888/firstEE/request?c=java&c=sql&c=html  
		//http://localhost:8888/firstEE/request?c=java&c=sql
		//http://localhost:8888/firstEE/request   null을 반환한다. 
		
		//주로 체크박스인 경우 java=
		String[]cArr = request.getParameterValues("c"); 
		if(cArr != null) {
			for(String c: cArr) {
				System.out.println(c); 
			}
		}
		//http://localhost:8888/firstEE/request?t=a
		System.out.println("request.getServletPath()" + request.getServletPath());  // /request
		System.out.println("request.getContextPath()" + request.getContextPath()); // /firstEE
		System.out.println("request.getProtocol()" + request.getProtocol());  // HTTP/1.1
		System.out.println("request.getRequestURI()" + request.getRequestURI()); // /firstEE/request
		System.out.println("request.getRequestURL()" + request.getRequestURL());  // http://localhost:8888/firstEE/request
	
		Enumeration<String> names = request.getHeaderNames(); 
		while(names.hasMoreElements()) {
			String name = names.nextElement();  //헤더일므 하나씩
			String value = request.getHeader(name);
			//Accept: 클라이언트WB가 해서할 수 있는 MINEcontexttype정보를 서버에 알린다. 
			//User-Agent  : 클라이언트컴퓨터의 OS정보, WB정보를 서버에 알리는 역할을 한다. 
			System.out.println("요청헤더명:" + name + ", 값" + value);
		}
	}
	
	

}
