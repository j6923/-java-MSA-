package com.my.cutomer.control;

import java.io.IOException;

import com.my.customer.dao.CustomerDAOOracle;
import com.my.customer.service.CustomerService;
import com.my.customer.vo.Customer;
import com.my.exception.FindException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청전달데이터 id, pwd 값얻기 
		String idValue = request.getParameter("id");  //id값을 얻어온다. 
		String pwdValue = request.getParameter("pwd");  //pwd의 값을 얻어온다. 
		System.out.println("LoginServlet의 doPost() id=" + idValue +", pwd="+ pwdValue); //값 출력 
		
		String resultMsg = ""; 
		CustomerService service;
		service = new CustomerService();
		
//		String path = "result";
		//2. 비즈니스로직 호출 
		try {
			service.login(idValue, pwdValue);
			System.out.println("로그인 성공");
			//3. 응답결과 만들기 
//			resultMsg = "로그인 성공";
			resultMsg = "이미 사용중인 아이디입니다";
//			path = "fail";
		}catch(FindException e) {
			System.out.println(e.getMessage());
			//3. 응답결과만들기 
			resultMsg = "로그인 실패"; //resultMsg = e.getMssage();
			resultMsg = "사용가능한 아이디입니다.";
//			path = "success";  //나중 
		}
		//4. 응답결과를 요청속성으로 설정하기 
		request.setAttribute("msg", resultMsg);
		
		
		//5.Viewer로 이동 
		String path = "result";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
//		CustomerDAOOracle dao;
//		dao = new CustomerDAOOracle();
//		try {
//			Customer c = dao.findById(idValue);
//			if(c.getPwd().equals(pwdValue)) {
//				System.out.println("로그인 성공");
//			}else {
//				System.out.println("로그인 실패"); //"비밀번호가 일치하지 않습니다"
//			}
//			
//		} catch (FindException e) {
//			e.printStackTrace(); 
//			System.out.println("로그인 실패");  //e.getMessage()-아이디가 없습니다
//		}
//		
	}

}
