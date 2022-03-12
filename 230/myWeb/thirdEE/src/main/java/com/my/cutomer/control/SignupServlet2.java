package com.my.cutomer.control;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.my.customer.service.CustomerService;
import com.my.customer.vo.Customer;
import com.my.exception.AddException;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		Customer c = new Customer(id,pwd, name, null);
		
		CustomerService service = new CustomerService();
		//String path = "result";
		String path = "jsonresult.jsp";
		try {
			service.signup(c);
			path = "success";
		}catch(AddException e) {
			e.printStackTrace();
			path= "fail";
		
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
