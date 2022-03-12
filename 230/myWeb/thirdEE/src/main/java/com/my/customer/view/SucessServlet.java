package com.my.customer.view;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SucessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// response.setContentType으로 응답 형식을 지정해 주는데 text/html형태로 응답하겠다.
		PrintWriter out = response.getWriter();
		out.print("1");  //1을 응답 
		
	}

}
