package com.my.cutomer.control;

import java.io.IOException;

import com.my.customer.service.CustomerService;
import com.my.customer.vo.Customer;
import com.my.exception.AddException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		Customer c = new Customer(id,pwd, name, null);
		CustomerService service = CustomerService.getInstance();
//		CustomerService service = new CustomerService();
		//String path = "result";
		String path = "jsonresult.jsp";
		String msg="";
		try {
			service.signup(c);
			request.setAttribute("status", 1);
			msg="가입성공";
		}catch(AddException e) {
			e.printStackTrace();
			request.setAttribute("status", 0);
			msg= e.getMessage();
		
			
		}
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
