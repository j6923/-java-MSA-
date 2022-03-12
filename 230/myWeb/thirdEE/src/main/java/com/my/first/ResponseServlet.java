package com.my.first;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
//    public ResponseServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답형식지정  : MIME 
		//가장 먼저 응답형식응 지정해야 한다. 
		
		response.setContentType("text/html;charset=UTF-8"); //text/html 응답하는 내용을 html형태로 응답할거야 정확히 알리는 것 
		//text/plain 응답할 내용을 순수 문자열 형태로 응답할거야 . ?>> 랜더링 엔진이 html 해석하지 못하도록 함. 
		//클라이언트에게 응답하려면 response객체 써야 한다. 
		//charset=UTF-8웹 브라우저 글자깨짐 방지 
		
		//응답출력스트림에 얻기 
		PrintWriter out = response.getWriter();
		//문자 단위로 쓰기를 해줌. 
		
		//응답출력스트림에 출력 
		out.print("<h1 style=\" background-color:yellow;\">");  //out.println은 줄바꿈이 자종으로 되고 print로 하면 줄바꿈이 되지 앟는다. 
		//웹 브라우저에 보여줄 떄는 상관이 없다. 
		out.print("hello안녕"); //클라이언트에게 응답 줌 
		out.print("</h1>");
		//print로 하는 것이 네트워크 비용을 줄일 수 있다. 
		
	}

}
