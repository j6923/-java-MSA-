package com.my.cart.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PutCartServlet
 */
public class PutCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청전달데이터 얻기 
		String prodNo = request.getParameter("prodNo");
		String quantity = request.getParameter("quantity");//리턴 타입이 string 
		int intQuantity = Integer.parseInt(quantity); //quantity를 int타입으로 바꿈.
		
		
		HttpSession session = request.getSession(); //session객체란 서버쪽에 존재하는 클라이언트 객체 
		
		//새션객체의 속성중 cart이름의 속성찾기 
		Map<String, Integer>cart = (Map)session.getAttribute("cart");  //Map타입으로 형변환 
		//cart이름의 속성 없으면(null이다) cart이름(이름:cart, 값: Map<String, Integer>)의 속성추가
		if(cart==null) {
			cart = new HashMap<String, Integer>();
			session.setAttribute("cart", cart);
			
		}
		//cart에 상품번호에 해당상품이 있다면 기존수량에 intQuantity를 누적 
		//cart에 상품번호에 해당상품이 없다면 cart의 값으로 prodNo, intQuantity추가 
		Integer cartQuantity = cart.get(prodNo); //상품이 있는가 물어보기
		if(cartQuantity != null) {//cart에 상품번호에 해당상품이 있다면 
			intQuantity +=cartQuantity; // 오토박싱으로 안 하느냐 > 
		}
		cart.put(prodNo,intQuantity);
		
		//cart얻어오고 put메서드를 이용해서  
		//-----cart 확인-----------
		Set<String> prodNos = cart.keySet(); //keyset은 키들만 얻어온다. 
		for(String pNo: prodNos) {
			Integer qt = cart.get(pNo);
			System.out.println(pNo + ":" + qt);
			//맵은 인덱스가 없다. 
			//서비스 메서드만 쓰고 요청방식이 get이건 post이건 구분 안하니까 service 오버라이딩하고 post방식으로 처리해야 하지만 get방식으로 query string만들어서 test하면 된다. 
		}
	}

}
