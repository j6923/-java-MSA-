package com.my.first;

import java.io.IOException;

import jakarta.servlet.ServletContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private String fileName;
	@Override
	
	public void init() throws ServletException {
		
		super.init();
		fileName = this.getInitParameter("fileName");
		//getInitParameter라는 메서드를 이용해서 fileName이라는 Parameter이름을 사용하고 그 값을 fileName에 저장하여 사용한다. 
		ServletContext sc = this.getServletContext();
		String developer = sc.getInitParameter("developer");
		System.out.println(developer);
	}


	private static final long serialVersionUID = 1L;
	
//	String fileName = "a.txt"; //메서드 내의 지역변수가 아니라 객체내의 멤버 변수로 바꿈. 
	//이렇게 해서 써도 괜찮다. 
	//a.txt값으로 변경하지 않고 쓰겠다고 하면 고정되서 사용된다면 효과는 같게 된다. 
	String charset = "UTF-8";

private String fileName;
	//중국 클라이언트면 중국 인코딩 형태로 응답을 하고 일본 클라이언트가 요청하면 일본 인코딩 형태로 응답하고 싶다. 
	//ip 체계에 따라 인코딩이 바뀌어야 하면 
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String fileName = "a.txt"; //요청시마다 하면 파일 이름이 매번 만들어지낟, 
//		String fileName = this.getInitParameter("fileName");  //fileName을 받아온다. 
		//2차버전에서 web.xml이라는 자바 클래스가 아닌 설정 클래스를 바꾸게 된다. 
		System.out.println("사용할 파일명:" + fileName);
	}

}
