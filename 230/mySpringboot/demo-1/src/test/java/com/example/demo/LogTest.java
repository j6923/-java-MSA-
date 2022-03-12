package com.example.demo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class LogTest {
	private Logger log = 
			LoggerFactory.getLogger(getClass());
	@Test
	void test() {
		log.debug("DEBUG LEVEL 로그");
		log.info("INFO LEVEL 로그");
		log.warn("WARN LEVEL 로그");
		log.error("ERROR LEVEL 로그");
	}
	
	
	@Test
	void testLoop() {
		for(int i=0; i<10000; i++) {
			log.debug("DEBUG LEVEL 로그" +i);
			log.info("INFO LEVEL 로그" + i);
			log.warn("WARN LEVEL 로그" + i);
			log.error("ERROR LEVEL 로그" + i);
		}
	}
}
