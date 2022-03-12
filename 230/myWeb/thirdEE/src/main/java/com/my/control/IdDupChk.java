package com.my.control;

import java.io.IOException;

import com.my.customer.service.CustomerService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class IdDupChk implements Controller {
	private CustomerService service = CustomerService.getInstance();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String resultMsg="";
		String idValue = request.getParameter("id");
		System.out.println(idValue);
//		CustomerService service = new CustomerService();
		//String path = "result";
		String path = "jsonresult.jsp";
		try {
			service.iddupchk(idValue);
			resultMsg ="이미 사용중인 아이디입니다.";
//			path = "fail";
			request.setAttribute("status", 0);
		}catch(Exception e ) {
			resultMsg = "사용 가능한 아이디입니다.";
			//path = "success";
			request.setAttribute("status", 1);
		}
		//4.응답결과를 요청속성으로 설정 
		
		
		
		
	
		return path;
	}

}
