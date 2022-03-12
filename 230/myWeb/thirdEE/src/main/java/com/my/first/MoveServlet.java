package com.my.first;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MoveServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//요청전달데이터opt값 얻기 
		String opt = request.getParameter("opt");
		if(opt == null) {
			out.print("<a href=\"move?t=aaa&opt=redirect\">리다이렉트</a><br>");
			out.print("<a href=\"move?t=aaa&opt=forward\">포워드</a><br>");
			out.print("<a href=\"move?t=aaa&opt=include\">인클루드</a>");
			// 없을 떄 a 테그 보여줌. 
		}else if(opt.equals("redirect")) {
			String resultMsg = "성공";
			request.setAttribute("msg", resultMsg);
			
			response.sendRedirect("result"); //result servlet으로 이동 
//			response.sendRedirect("/result"); //context path를 바꾸는 것 
			
		}else if(opt.equals("forward")) {
			out.print("before forward"); //버퍼에 쌓였다가 
			
			String resultMsg = "성공";
			request.setAttribute("msg", resultMsg);
			
			String path = "/result"; //웹 컨테스트 밑에 
//			String path = "result"; //서버 사이드 입장에서 웹 컨테스트 
			RequestDispatcher rd = request.getRequestDispatcher(path);//페이지 이동  //result servlet으로 이동 
			rd.forward(request,response); 
			out.print("after forward"); //클리어가 되서 response가 돌아오지 않아 효과가 없다. 그래서 구문 처리 안됨 
			
		}else if(opt.equals("include")) {
			out.print("before include");
			String path = "result"; 
			RequestDispatcher rd = request.getRequestDispatcher(path);//페이지 이동  //result servlet으로 이동 
			rd.include(request,response); // 전달이 되었다가 돌아옴 
			out.print("after forward");
		}
	}

}
