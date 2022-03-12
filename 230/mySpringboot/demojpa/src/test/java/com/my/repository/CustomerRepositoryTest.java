package com.my.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.my.customer.entity.Customer;

@SpringBootTest
class CustomerRepositoryTest {
	
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Autowired
	private CustomerRepository repository;
	@Test
	@Transactional  //자동 commit 막음 
	@Commit  // transactional 하고 commit안 하면 insert가 안됨 
	//두 개 어노테이션 설정 하는 것과 안 하는 것은 한 개 테스트 할 때는 효과가 없지만 메서드내에서 항상 같은 트렌젝션을 쓰게 됨 (어노테이션쓰면) 
	//
	void testSave() {
		Customer c1 = new Customer("id", "p1", "n1");
		repository.save(c1);  //insert 
		logger.info("--1. saved--------");
		Customer c2 = new Customer("id1", "비1", "이1");
		repository.save(c2);//update
		logger.info("--2. saved--------");
		// insert 처리, update 처리 
		
	}
	@Test
	@Transactional
	void testFindById() {
		String id = "id1";
		Optional<Customer> optC1 = repository.findById(id);  //2차캐시작업진행 select-> 엔터티객체관리  -> 엔터티객체반환
		assertTrue(optC1.isPresent());
		
		Optional<Customer> optC2 = repository.findById(id);  //1차 캐시작업 진행 엔터티객체반환 
		assertTrue(optC2.isPresent());
		
		Customer c2 = optC2.get();
		assertTrue(entityManager.contains(c2));//Persistence Context에 id1용 Customer 객체 존재 
}
	
	@Test
	@Transactional 
	void testFindAll() {
		Iterable<Customer> all = repository.findAll();  //2차 캐시작엊 select 
		Iterable<Customer> all2 = repository.findAll();  //2차캐시작업 select 
		//logger.info("findAll=" + all);
		
		
	}
	@Test 
	@Transactional
	@Commit
	void testDelete() {
		String id = "id2";
		repository.deleteById(id);
		//repository.delete(); 해도 됨. 
		
	}
	@Test
	@Transactional
	@Commit
	void testUpdate() {
		String id = "id1";
		Optional<Customer> optC = repository.findById(id);//자료가 있는지 먼저 검색 
		assertTrue(optC.isPresent());
		Customer c = optC.get();
		assertEquals("이1", c.getName());
		
		c.setName("이름1");// 데이터 변경 
		repository.save(c);// save 
		
	}
	
	
	@Test
	void testFindByName() {
		String name = "이름";
		List<Customer>list = repository.findByName(name);
		int expectedSize = 2; 
		assertTrue(expectedSize == list.size());
		
	}
	@Test
	void testFindByNameLike() {
		String word = "%이름$";
		List<Customer> list = repository.findByNameLike(word);
		list.forEach(c->logger.info("아이디: " + c.getId()+ ",이름:"+ c.getName()));
//		for(Customer c: list) {
//			logger.info("아이디: " + c.getId()+ ",이름:"+ c.getName());
//		}
	}
	
	

	
}
