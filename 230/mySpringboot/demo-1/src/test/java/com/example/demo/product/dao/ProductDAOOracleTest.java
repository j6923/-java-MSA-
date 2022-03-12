package com.example.demo.product.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.exception.FindException;
import com.example.demo.product.vo.Product;

@SpringBootTest
public class ProductDAOOracleTest {

	@Autowired
	@Qualifier("pDAO")  //pDAO를 정확히 찾아서 밑에 있는 dao에 주입시킨다. 
	private ProductDAOInterface dao;
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Test
	public void testFindByNo() throws FindException {  //드래그 선택 
		//통과되었으면 초록색 체크박스, 단정지은 test가 단정 지어지지 않으면 빨간 x 값 나옴 //자바 등 근처 다 알기 
		String prod_no = "C0001";  //상품 반드시 존재하고 //예상되는 이름이 아메리카노이다. 
		log.debug("DEBUG LEVEL LOG");
		log.info("INFO LEVEL LOG");
		log.warn("WARN LEVEL LOG");
		log.error("ERROR LEVEL LOG");
		
		Product p = dao.findByNo(prod_no); //DB검색결과
		System.out.println(p.getProdName().equals("아메리카노"));//이것은 단지 콘솔에 출력, 통과되었는지는 안 나옴 .출력에서 끝나게 됨 
		//tomcat하지 않고도 주입할 수 있도록 qutowird함. 
		//p가 가지고 있는 이름은 마메리카노이고 가격은 1000원으로 예상함. 
		String expectedProdName = "아메리카노";//예상
		int expectedProdPrice = 1000;
		
		assertEquals(expectedProdName, p.getProdName());
//		assert는 예상한다고 봐야하는데 내가 예상한 값과 실제 test해온 결과값이 일치하는 것이 일치하는지 묻는 메서드 
		//같으면 test를 통과하고 같지 않으면 예상괎과 실제값이 일치하지 않으면 콘솔창에 빨간 박스가 나온다. 
		assertTrue(expectedProdPrice == p.getProdPrice());
		//비교연산의 결과가 true인지 묻는 메서드 
		//p.getProdPrice는 실제 가격 값 
		//expectedProdePrice는 예상 값 
		//junit에 단정한 내용이 맞으면 녹색, 맞지 않으면 빨간 x표시 나옴. 
	}

	@Test
	public void testFindAll() throws FindException {
		System.out.println("testSelectAll메서드호출");
		List<Product>list = dao.findAll();// dao의 findAll을 해본다. dao.findALl이 잘 만들어졌으면 10이다. 
		int expectedSize = 10; //예상
		assertTrue(expectedSize == list.size());
		
		Product p = list.get(0);
		String expectedProdName = "ICE라테";
		assertEquals(expectedProdName,p.getProdName());
	}	


}
