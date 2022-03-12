package com.example.demo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderWeb1ApplicationTests {
	@Autowired
	private SqlSessionFactory factory;
	@Test
	void contextLoads() {
	}

}
