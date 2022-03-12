package com.my.order.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.my.customer.vo.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.order.vo.OrderInfo;
import com.my.order.vo.OrderLine;
import com.my.product.vo.Product;



@SpringBootTest
public class OrderDAOOracleTest {

	@Autowired
	@Qualifier("oDAO")
	private OrderDAOInterface dao;
	private Logger log = 
			LoggerFactory.getLogger(getClass());
	@Test
	public void testAdd() {
		OrderInfo info = new OrderInfo();
		Customer c = new Customer();
		info.setOrderCustomer(c);
		String orderId = "id999";
		c.setId(orderId);// 주문자 셋팅 
		
		List<OrderLine> lines = new ArrayList<>();
		info.setLines(lines);
		
		OrderLine line = new OrderLine(); //lines에 추가시켜놓음 
		lines.add(line);
		
		String orderProdNo = "C0001";  //주문상품번호 
		int failOrderQuantity = 1*100;  //주문수량   //잘못된 수량으로 100개 넣어놓음. 
		Product p = new Product();  
		p.setProdNo(orderProdNo);
		line.setOrderProduct(p);
		line.setOrderQuantity(failOrderQuantity);
		try {
			dao.add(info); //주문기본정보와 주문상세 정보가 add가 호출이 되고 orderInfo작업에서는 성공될 것이다. 
		} catch (AddException e1) {
			e1.printStackTrace();
		}
		
//		try {
//			List<OrderInfo> infos = dao.findById(orderId);
//		
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}	


}
