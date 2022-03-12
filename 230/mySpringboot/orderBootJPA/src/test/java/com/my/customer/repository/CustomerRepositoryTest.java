package com.my.customer.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.my.customer.vo.Customer;

@SpringBootTest
class CustomerRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CustomerRepository repository;
	
	@Test
	void testInsert() {
		Customer c = new Customer("jpa1", "jpap", "jpan", null);
		repository.save(c);
		
	}

}
