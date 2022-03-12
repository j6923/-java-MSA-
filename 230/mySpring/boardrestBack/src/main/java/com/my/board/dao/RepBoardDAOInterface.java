package com.my.board.dao;

import java.util.List;

import com.my.board.vo.RepBoard;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;

public interface RepBoardDAOInterface {
	/**
	 * 글쓰기, 답글쓰기
	 * @param repBoard 게시글
	 * @throws AddException
	 */
	public void add(RepBoard repBoard) throws AddException;
	
	/**
	 * 1페이지를 검색한다. 한페이지당 보여줄 목록수는 5건이다
	 * @return
	 * @throws FindException
	 */
	public List<RepBoard> findAll() throws FindException;
	
	/**
	 * 페이지번호에 해당하는 게시글을 검색한다
	 * @param currentPage 검색할 페이지번호
	 * @param cntPerPage  페이지당 보여줄 목록수
	 * @return
	 * @throws FindException
	 */
	public List<RepBoard> findAll(int currentPage, int cntPerPage) throws FindException;
	
	/**
	 * 글번호로 게시글 검색한다
	 * @param boardNo 글번호
	 * @return 
	 * @throws FindException
	 */
	public RepBoard findByNo(int boardNo) throws FindException;
	
	/**
	 * 단어를 포함한 제목이나 내용의 게시글 검색한다
	 * @param word
	 * @return
	 * @throws FindException
	 */
	public List<RepBoard> findByWord(String word) throws FindException;
	
	/**
	 * 게시글의 조회수를 1증가한다
	 * @param boardNo 글번호
	 * @throws ModifyException
	 */
	public void plusViewCount(int boardNo) throws ModifyException;
	
	/**
	 * 게시글의 제목, 내용을 수정한다
	 * @param repBoard 
	 * @throws ModifyException
	 */
	public void modify(RepBoard repBoard) throws ModifyException;
	/**
	 * 게시글과 답글 삭제
	 * @param repBoard
	 * @throws RemoveException
	 */
	public void remove(RepBoard repBoard) throws RemoveException;
	/**
	 * 총 게시글 목록 수를 반환한다 
	 * @return 게시글 개수
	 * @throws FindException
	 */
	public int findCount() throws FindException;
	
	/**
	 * 제목이나 글내용에 해당단어를 포함한 글을 검색한다 
	 * @param word 단어
	 * @param currentPage 현재페이지
	 * @param cntPerPage 페이지별 보여줄 목록수
	 * @return
	 * @throws FindException
	 */
	public List<RepBoard> findByWord(String word, int currentPage, int cntPerPage) throws FindException;
	/**
	 * 해당단어를 포함한 게시글 목록 수를 반환한다 
	 * @param word 단어
	 * @return 게시글 개수
	 * @throws FindException
	 */
	public int findCount(String word) throws FindException;

}
