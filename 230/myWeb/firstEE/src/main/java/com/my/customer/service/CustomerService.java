package com.my.customer.service;

import com.my.customer.dao.CustomerDAOOracle;
import com.my.customer.vo.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;


public class CustomerService {
	private CustomerDAOOracle dao = CustomerDAOOracle.getInstance();
	
	private static CustomerService service = new CustomerService();
	private CustomerService() {
		
	}
	public static CustomerService getInstance() {
		
		return service; 
	}
	
	/**
	 * 아이디와 비번이 일치하는 고객이 존재하면 고객객체를 변환하고 
	 * 고객이 존재하지 않으면 FindException이 발생한다. 
	 * @param id
	 * @param pwd
	 * @return
	 * @throws FindException
	 */
	public Customer login(String id, String pwd) throws FindException{
//		dao = new CustomerDAOOracle();
		try {
			Customer c = dao.findById(id);
			if(c.getPwd().equals(pwd)) {
				return c;
			}
			throw new FindException("로그인 실패");
		}catch(FindException e) {
//			throw e;
			throw new FindException("로그인 실패");
		}
	}
	
	public void iddupchk(String id) throws FindException{
//		dao = new CustomerDAOOracle();
		
		
			Customer c=dao.findById(id);
		
	}

	public void signup(Customer c) throws AddException {
		// TODO Auto-generated method stub
		
	}
}
