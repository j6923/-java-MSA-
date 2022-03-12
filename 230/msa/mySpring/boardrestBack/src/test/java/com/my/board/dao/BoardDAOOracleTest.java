package com.my.board.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.my.board.vo.RepBoard;
import com.my.customer.vo.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;

//Spring용 단위테스트
@RunWith(SpringJUnit4ClassRunner.class) //Juni4인 경우

//Spring 컨테이너용 XML파일 설정
@ContextConfiguration(locations={
		/* "file:src/main/webapp/WEB-INF/spring/root-context.xml", */
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BoardDAOOracleTest {

	@Autowired
	
	private RepBoardDAOInterface dao;

//	@Test
//	public List<RepBoard> testfindAll() throws FindException {
//		String id = "id3";
//		List<RepBoard>list = dao.findAll(id); //DB검색결과
//
//		String expectedProdName = "아메리카노";//예상
//		int expectedProdPrice = 1000;
//		
//		assertEquals(expectedProdName, p.getProdName());
//		assertTrue(expectedProdPrice == p.getProdPrice());
//	}

//	@Test
//	public void testFindAll() throws FindException {
//		System.out.println("testSelectAll메서드호출");
//		List<RepBoard>list = dao.findAll();
//		int expectedSize = 6; //예상
//		assertTrue(expectedSize == list.size());
//	}	
	@Test
	public void testFindAll() throws FindException {
		
		List<RepBoard>list = dao.findAll();// dao의 findAll을 해본다. dao.findALl이 잘 만들어졌으면 10이다. 
		int expectedSize = 5; //예상
		assertTrue(expectedSize == list.size());
		
		RepBoard r = list.get(0);
		/*
		 * int String expectedboardcon = "내용1";
		 * assertEquals(expectedboardcon,r.getBoardContent());
		 */
	}
	@Test
	public void testFindByNo() {
		int boardNo = 1;
		//int boardNo = 99999;
		try {
		RepBoard rb = dao.findByNo(boardNo);
		assertTrue(0 == rb.getParentNo());
		assertEquals("id1", rb.getBoardC().getId());
		assertEquals("제목1", rb.getBoardTitle());
		assertTrue(0==rb.getBoardViewcount());
		}catch(FindException e) {
			assertEquals("게시글이 없습니다", e.getMessage());
			
		}
	}
	@Test
	public void testPlusViewCount() {
		int boardNo = 1;
		//int boardNO = 99999;
		try {
			//System.out.println("in testPlusViewCount()- 0");
			RepBoard rb1 = dao.findByNo(boardNo);
			//System.out.println("in testPlusViewCount()- 1");
			
			dao.plusViewCount(boardNo);
			//System.out.println("in testPlusViewCount()- 2");
			
			RepBoard rb2 = dao.findByNo(boardNo);
			int expectedViewCount = rb1.getBoardViewcount()+1;

			//System.out.println("in testPlusViewCount() expectedViewCount=" + expectedViewCount);
			//System.out.println("in testPlusViewCount() rb2.getBoardViewcount()= " + rb2.getBoardViewcount());
			assertTrue(expectedViewCount == rb2.getBoardViewcount());
		}catch(Exception e) {
			e.printStackTrace();
			assertEquals("게시글이 없습니다", e.getMessage());
		}
		
	}
	
	@Test
	public void testReply() {
		//int parentNo = 0;
		int parentNo = 1;
		String boardTitle = "1-re테스트";
		String boardContent="1-re 내용 테스트";
		Customer c = new Customer();
		c.setId("id1");
		RepBoard repBoard = new RepBoard();
		repBoard.setBoardNo(parentNo);
		repBoard.setBoardTitle(boardTitle);
		repBoard.setBoardContent(boardContent);
		repBoard.setBoardC(c);
		try {
			dao.add(repBoard);
			int boardNo=22;
			RepBoard newRb = dao.findByNo(boardNo);
			assertEquals(parentNo, newRb.getParentNo()); 
			assertEquals(boardTitle, newRb.getBoardTitle());
			assertEquals(c.getId(), newRb.getBoardC().getId());
			assertEquals(boardContent, newRb.getBoardContent());
			
			
		}catch(AddException e) {
			e.printStackTrace();
			//assertEquals("답글쓰기의 부모글번호가 없습니다.",e.getMessage());
		}catch(FindException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testModify() {
		
		int boardNo = 1;
		
		Customer c = new Customer();
		c.setId("id1");
		String boardContent="1-내용수정테스트";
		
		
		RepBoard repBoard = new RepBoard();
		repBoard.setBoardNo(boardNo);
		repBoard.setBoardC(c);
		repBoard.setBoardContent(boardContent);
		try {
			dao.modify(repBoard);
			RepBoard rb1 = dao.findByNo(boardNo);
			
			assertEquals(boardContent, rb1.getBoardContent());
		}catch(ModifyException e) {
			e.printStackTrace();
		}catch(FindException e) {
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void tesRemove() {
		int boardNo = 1;
		Customer c = new Customer();
		c.setId("id1");
		RepBoard repBoard = new RepBoard();
		repBoard.setBoardNo(boardNo);
		repBoard.setBoardC(c);
		
		try {
			dao.remove(repBoard);
			
		} catch (RemoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//원글
		try {
			dao.findByNo(boardNo);
		} catch (FindException e) {
			
			
			assertEquals("게시글이 없습니다.", e.getMessage());
		}
		int replyBoardNo = 5; 
		try {
			dao.findByNo(replyBoardNo);
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertEquals("게시글이 없습니다.", e.getMessage());
		}
		
	}
}
