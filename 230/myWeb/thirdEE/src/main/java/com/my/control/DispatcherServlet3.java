package com.my.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet3 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

   
	protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
//		Controller control = null;
//		if("/productlist".equals(servletPath)) {
//			control = new ProductList();
//		}else if("/productdetail".equals(servletPath)) {
//			control = new ProductDetail();
//		}
		
		//1.control.properties파일 실제 경로찾기
		ServletContext sc = this.getServletContext();
		String controlConfigPath = sc.getRealPath("config\\control.properties");
		
		Properties env = new Properties();
		env.load(new FileInputStream(controlConfigPath));
		String controlClassName = env.getProperty(servletPath);
		try {
			Class clazz = Class.forName(controlClassName);
			Object obj = clazz.newInstance();
			Controller control = (Controller)obj;
			String path = control.execute(request, response);
			if(path == null || path.equals("")) {

//			if else로 하면 if...else구문이 점점 늘어나서 좀 더 간결히 하려면 reflection해줘야 함. 
			
			}else {
				//VIEWER로 이동
				RequestDispatcher rd = request.getRequestDispatcher(path);
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

		
	}

