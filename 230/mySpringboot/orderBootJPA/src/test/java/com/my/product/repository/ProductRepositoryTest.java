package com.my.product.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.my.product.vo.Product;

@SpringBootTest
class ProductRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Autowired
	private ProductRepository repository;
	
	
	@Test
	void findAll() {
		Product p1 = new Product("C0001", "아메리카노", 1000);
		repository.findAll();  //insert 
		logger.info("--1. saved--------");
		
//		Product p1 = new Product("C0001", "아메리카노", 1000);
//		repository.findByProdNoOrProdNameOrProdPriceLike("C0001", "아메리카노", 1000);  //insert 
//		logger.info("--1. saved--------");
		
		
	}
	
//	@Test
//	void findById() {
//		Product p1 = new Product("C0001", "아메리카노",1000);
//		repository.findById(1000);
//		logger.info("--아메리카노 나와라--------");
//	}
	
//	@Test
//	@Transactional
//	@Commit
//	void findByProdNoOrProdName() {
//		Product p1 = new Product("C0001", "아메리카노");
//		repository.findByProdNoOrProdNameLike("C0001", "아메리카노");  //insert 
//		repository.findByProdNoOrProdNameOrProdPriceLike("C0001", "아메리카노",1000);  //insert 
//		logger.info("--- 찾았다 --------");
//	}

	/*
	 * @Test
	 * 
	 * @Transactional
	 * 
	 * @Commit void findByIdTest() { Product p2 = new Product("C0002"); repository.
	 * 
	 * }
	 */
	
	
}
