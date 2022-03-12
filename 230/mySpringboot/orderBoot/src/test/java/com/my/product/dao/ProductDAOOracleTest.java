package com.my.product.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.my.exception.FindException;
import com.my.product.vo.Product;



@SpringBootTest
public class ProductDAOOracleTest {

	@Autowired
	@Qualifier("pDAO")
	private ProductDAOInterface dao;
	private Logger log = 
			LoggerFactory.getLogger(getClass());
	@Test
	public void testFindByNo() throws FindException {
		String prod_no = "C0001";
		
		Product p = dao.findByNo(prod_no); //DB검색결과
		
		String expectedProdName = "아메리카노";//예상
		int expectedProdPrice = 1000;
		
		assertEquals(expectedProdName, p.getProdName());
		assertTrue(expectedProdPrice == p.getProdPrice());
	}

	@Test
	public void testFindAll() throws FindException {
		System.out.println("testSelectAll메서드호출");
		List<Product>list = dao.findAll();
		int expectedSize = 10; //예상
		assertTrue(expectedSize == list.size());
		
		Product p = list.get(0);
		String expectedProdName = "ICE라테";
		assertEquals(expectedProdName, p.getProdName());
	}	


}
