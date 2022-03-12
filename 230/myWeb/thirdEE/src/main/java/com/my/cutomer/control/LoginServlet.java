package com.my.cutomer.control;

import java.io.IOException;

import com.my.customer.service.CustomerService;
import com.my.customer.vo.Customer;
import com.my.exception.FindException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청전달데이터 id, pwd 값얻기 
		String idValue = request.getParameter("id");
		String pwdValue = request.getParameter("pwd");
		System.out.println("LoginServlet의 doPost() id=" + idValue +", pwd="+ pwdValue);
		
		String resultMsg = ""; 
		CustomerService service;
		service = new CustomerService();
		
		HttpSession session = request.getSession();
		session.removeAttribute("loginInfo");  // 초기화 
		
		
		String path = "jsonresult.jsp";
		//2. 비즈니스로직 호출 
		try {
			Customer c = service.login(idValue, pwdValue);
			System.out.println("로그인 성공");
			session.setAttribute("loginInfo",c);
			//3. 응답결과 만들기 
			resultMsg = "로그인 성공";
			//resultMsg = "이미 사용중인 아이디입니다";
			request.setAttribute("status", 1);
			
		}catch(FindException e) {
			System.out.println(e.getMessage());
			//3. 응답결과만들기 
			resultMsg = "로그인 실패"; //resultMsg = e.getMssage();
			//resultMsg = "사용가능한 아이디입니다.";
			  //나중 
			request.setAttribute("status", 0);
		}
		//4. 응답결과를 요청속성으로 설정하기 
		request.setAttribute("msg", resultMsg);
		
		
		//5.Viewer로 이동 
		//String path = "result";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		

	}

}
