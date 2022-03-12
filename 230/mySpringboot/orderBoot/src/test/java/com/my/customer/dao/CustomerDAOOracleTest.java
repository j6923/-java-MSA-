package com.my.customer.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.my.customer.vo.Customer;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
@SpringBootTest
public class CustomerDAOOracleTest {
	@Autowired
	private CustomerDAOInterface dao;
	
	@Test
	public void findById() throws FindException{
		String id = "id1";
		Customer c = dao.findById(id);
		String expectedName = "오문정";
		String expectedPwd = "pp1";
		String expectedAddress = "서울";
		assertEquals(expectedName, c.getName());		
	}
	
	@Test
	public void modify() throws ModifyException, FindException {
		Customer c = new Customer();
		c.setId("id1");
		c.setPwd("pp1");
		c.setAddress("경기도");
		dao.modify(c);
		
		Customer c1 = dao.findById("id1");
		String expectedPwd = "pp1";
		String expectedName = "오문정";
		String expectedAddress = "경기도";
		assertEquals(expectedPwd, c1.getPwd());
		assertEquals(expectedName, c1.getName());
		assertEquals(expectedAddress, c1.getAddress());		
	}
}
