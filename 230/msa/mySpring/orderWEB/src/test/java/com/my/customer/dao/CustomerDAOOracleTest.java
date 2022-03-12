package com.my.customer.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.customer.vo.Customer;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
//Spring용 단위테스트
@RunWith(SpringJUnit4ClassRunner.class) //Juni4인 경우
//스프링용 
//굳이 tomcat구동 안 하고 test가 진행될 수 있도록 

//Spring 컨테이너용 XML파일 설정
@ContextConfiguration(locations={
		/* "file:src/main/webapp/WEB-INF/spring/root-context.xml", */
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})//스프링용 설정파일 
		//스프링용 컨테이너 중에서도 webApplicationcontext, 스프링 컨테이너용 context파일 
//원래는 tomcat시작 시 dispathcher 서블릿객체가 생성되고 springcontainer 구동할 떄 필요한 파일이 context.xml파일 
//스프링 container통해서 관리가 됨. 
public class CustomerDAOOracleTest {
	@Autowired
	private CustomerDAOInterface dao;
	
	
	@Test
	public void findById() throws FindException{
		String id = "id1";
		Customer c = dao.findById(id);
		String expectedName = "오문정";
		String expectedpwd = "p1";
		//변수만 선언하고 assertEquals로 비교하지 않아 단위 테스트 통과됨. 
		String expectedAddress = "서울";
		assertEquals(expectedName,c.getName());
		
		
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
