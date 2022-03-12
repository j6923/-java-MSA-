package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

   
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		Controller control = null;
		if("/productlist".equals(servletPath)) {
			control = new ProductList();	
		}else if("/productdetail".equals(servletPath)) {
			control = new ProductDetail();
			
		}
		String path = control.execute(request, response);
		System.out.println(path);
		if(path==null||path.equals("")) {
//			if else로 하면 if...else구문이 점점 늘어나서 좀 더 간결히 하려면 reflection해줘야 함. 
			
		}else {
//			오버라이딩된 execute메서드가 호출이 되게 된다. 
			
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter out=response.getWriter();
//			out.print("<h1>DISPATCHER SERVLET servletPath:+" +servletPath+"</h1>");
			
			//VIEWER로 이동
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
			
		}
		
	}

}
