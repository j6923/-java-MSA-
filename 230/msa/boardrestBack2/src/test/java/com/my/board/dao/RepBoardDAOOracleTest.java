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
import com.my.dto.PageDTO;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
@RunWith(SpringJUnit4ClassRunner.class) //Juni4인 경우
@ContextConfiguration(locations={
		/* "file:src/main/webapp/WEB-INF/spring/root-context.xml", */
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class RepBoardDAOOracleTest {
	@Autowired
	private RepBoardDAOInterface dao;
	
	@Test
	public void test() throws FindException {
		List<RepBoard> list = dao.findAll();
		int expectedSize = 5;
		assertTrue(list.size() == expectedSize);
		RepBoard r = list.get(0);
		int expectedNo = 2;
		int expectedParentNo = 0;
		String expectedId = "id2";
		assertTrue(r.getBoardNo() == expectedNo);
		assertTrue(r.getParentNo() == expectedParentNo);
		assertEquals(expectedId, r.getBoardC().getId());
		assertTrue(r.getBoardViewcount()==0);
	}
	
	@Test
	public void testFindByNo() {
		//int boardNo = 1;
		int boardNo = 99999;
		try {
			RepBoard rb = dao.findByNo(boardNo);
			assertTrue(0 == rb.getParentNo());
			assertEquals("id1", rb.getBoardC().getId());
			assertEquals("제목1", rb.getBoardTitle());
			assertTrue(0 == rb.getBoardViewcount());
		}catch(FindException e) {
			assertEquals("게시글이 없습니다", e.getMessage());
		}
	}
	@Test
	public void testPlusViewCount() {
		int boardNo = 1;
//		int boardNo = 99999;
		try {
			RepBoard rb1 = dao.findByNo(boardNo);
			dao.plusViewCount(boardNo);
			RepBoard rb2 = dao.findByNo(boardNo);
			int expectedViewCount = rb1.getBoardViewcount()+1;
			assertTrue(expectedViewCount == rb2.getBoardViewcount());
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("게시글이 없습니다", e.getMessage());
		}
	}
	
	@Test
	public void testReply() {
		int parentNo = 1; //1번글의 답글쓰기 테스트
//		int parentNo = 0; //답글쓰기 실패인 경우 테스트
		String boardTitle = "1-re제목테스트";
		Customer c = new Customer();
		c.setId("id1");
		String boardContent = "1-re내용테스트";
		RepBoard repBoard = new RepBoard();
		repBoard.setParentNo(parentNo);
		repBoard.setBoardTitle(boardTitle);
		repBoard.setBoardC(c);
		repBoard.setBoardContent(boardContent);
		
		try {
			dao.add(repBoard);
			int boardNo = 23;
			RepBoard newRb = dao.findByNo(boardNo);
			assertEquals(parentNo, newRb.getParentNo());
			assertEquals(boardTitle, newRb.getBoardTitle());
			assertEquals(c.getId(), newRb.getBoardC().getId());
			assertEquals(boardContent, newRb.getBoardContent());
		} catch (AddException e) {
			e.printStackTrace();
			//서비스테스트할때 필요!assertEquals("답글쓰기의 부모글번호가 없습니다", e.getMessage());
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModify() {
		int boardNo = 1; //1번글의 수정 테스트
		Customer c = new Customer(); //1번글 작성자
		c.setId("id1");
		String boardContent = "1-내용수정테스트";
		
		RepBoard repBoard = new RepBoard();
		repBoard.setBoardNo(boardNo);
		repBoard.setBoardC(c);
		repBoard.setBoardContent(boardContent);
		try {
			dao.modify(repBoard);
			RepBoard rb1 = dao.findByNo(boardNo);
			assertEquals(boardContent, rb1.getBoardContent());
			
		} catch (ModifyException e) {
			e.printStackTrace();
		} catch (FindException e) {
			e.printStackTrace();
		}
		
	}	
	
	@Test
	public void testRemove() {
		int boardNo = 1; //1번글의 삭제 테스트. 1번글의 답글은 5번글이 있다
		                 //테스트로 1번글과 5번글이 모두 삭제되어야한다
		Customer c = new Customer(); //1번글 작성자
		c.setId("id1");
		RepBoard repBoard = new RepBoard();
		repBoard.setBoardNo(boardNo);
		repBoard.setBoardC(c);
		try {
			dao.remove(repBoard);
		} catch (RemoveException e) {
			e.printStackTrace();
		}
		
		//원글 삭제테스트
		try {
			dao.findByNo(boardNo);
		} catch (FindException e) {
			assertEquals("게시글이 없습니다", e.getMessage());
		}
		//답글 삭제테스트
		int replyBoardNo = 5;
		try {
			dao.findByNo(replyBoardNo);
		} catch (FindException e) {
			assertEquals("게시글이 없습니다", e.getMessage());
		}
		
	}
	@Test
	public void testFindByWord() throws FindException {
		String word = "글";
		List<RepBoard> pageDTO = dao.findByWord(word);
		
	}
}
