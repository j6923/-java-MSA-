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

import com.my.exception.FindException;
import com.my.product.service.ProductService;
import com.my.product.vo.Product;

import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class CartListServlet
 */
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //session 얻기 
		Map<String, Integer>cart = (Map)session.getAttribute("cart");
		if(cart == null|| cart.size()==0){
			//상품을 한 번도 넣은 적이 없는 상태  //장바구니는 있는데 내용이 없는 경우  
			
		}else {
			//장바구니의 상품번호들 얻기
			Set<String>prodNos=cart.keySet();
			
			
			//응답용 자료구조 
			Map<Product, Integer> responseMap = new HashMap<>(); //응답용 맵 
			
			ProductService service = new ProductService();
			
			//상품번호별 상품정보 찾기, 상품번호별 수량 얻기
			for(String prodNo : prodNos) {
				try {
					Product p = service.findByNo(prodNo); //상품번호별 상품정보 찾기
					int quantity = cart.get(prodNo);//상품번호별 상품정보 찾기, 상품번호별 수량 얻기
					responseMap.put(p, quantity); //응답용자료구조에 추가 
				} catch (FindException e) {
//					e.printStackTrace();// 오라클 문제가 있거나 
				}
				request.setAttribute("cart", responseMap);
				System.out.println(responseMap);
			}
			
		}//end if
		String path = "cartlistresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		

	}

}
