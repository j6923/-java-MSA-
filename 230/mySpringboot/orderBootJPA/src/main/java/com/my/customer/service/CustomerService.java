package com.my.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.customer.dao.CustomerDAOInterface;
import com.my.customer.repository.CustomerRepository;
import com.my.customer.vo.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;
@Service
public class CustomerService {
	@Autowired
	private CustomerRepository dao; 
	
	
	/**
	 * 아이디와 비번이 일치하는 고객이 존재하면 고객객체를 반환하고
	 * 고객이 존재하지 않으면 FindException이 발생한다
	 * @param id
	 * @param pwd
	 * @return
	 * @throws FindException
	 */
	public Customer login(String id, String pwd) throws FindException{
		//dao = new CustomerDAOOracle();
		//dao = CustomerDAOOracle.getInstance();
		try {
			Optional<Customer> optC = dao.findById(id);
			//Optional<Customer> d = dao.findById(pwd);
//			if(c.get().equals(pwd)) {
//				return c.get();
//			}
			if(optC.isPresent()) {
				Customer c = optC.get();
				if(c.getPwd().equals(pwd)) {
					return c;
				}
			}
			throw new FindException();
		}catch(FindException e) {
			e.printStackTrace();
			//throw e;
			throw new FindException("로그인 실패");
		}
	}
	/**
	 * 아이디에 해당하는 고객이 존재하면 "이미 사용중인 아이디입니다"메시지를 갖는 FindException이 발생한다
	 * @param id
	 * @throws FindException
	 */
	public void iddupchk(String id) throws FindException{
		//dao = new CustomerDAOOracle();
		dao.findById(id);
	}
	public void signup(Customer c) throws AddException{
		//dao = new CustomerRepository();
		//dao.add(c);
		((CustomerDAOInterface) dao).add(c);
	}
}
