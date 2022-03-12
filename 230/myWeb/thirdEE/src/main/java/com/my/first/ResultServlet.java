package com.my.first;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//do post가 없으면 post로 연결할 때 405번 에러가 발생한다. 
/**
 * Servlet implementation class ResultServlet
 */
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ResultServlet() {
        super();
       
    }

	//doGet을 service로 변경함. 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답형식지정 
		response.setContentType("text/html;charset=UTF-8");
		//응답출력스트림얻기 
		PrintWriter out = response.getWriter();
		
		Object resultMsg = request.getAttribute("msg");
		out.print(resultMsg + "결과-요청전달데이터t값:" + request.getParameter("t"));
		
		//do get 메서드와 do post가 할 것이 같다라고 하면 메서드 service메서드만 오버라이딩하면 된다. 
	}

}
