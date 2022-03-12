package com.my.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.board.dao.RepBoardDAOInterface;
import com.my.board.vo.RepBoard;
import com.my.dto.PageDTO;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;

@Service
public class RepBoardService {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RepBoardDAOInterface dao;
	/**
	 * 글쓰기
	 * @param repBoard
	 * @throws AddException
	 */
	public void write(RepBoard repBoard) throws AddException{
		repBoard.setParentNo(0);
		dao.add(repBoard);
	}
	/**
	 * 답글쓰기
	 * @param repBoard
	 * @throws AddException
	 */
	public void reply(RepBoard repBoard) throws AddException{
		if(repBoard.getParentNo() == 0) {
			throw new AddException("답글쓰기의 부모글번호가 없습니다");
		}
		dao.add(repBoard);
	}
	
	public PageDTO<RepBoard> findAll() throws FindException{
		return findAll(1);
	}

	public PageDTO<RepBoard> findAll(int currentPage) throws FindException{
		String url = "/board/list";
		int totalCnt = dao.findCount();
		List<RepBoard> list = dao.findAll(currentPage, PageDTO.CNT_PER_PAGE);
		PageDTO<RepBoard> pageDTO = new PageDTO<>(url, currentPage, totalCnt, list);
		return pageDTO;
	}
	public PageDTO<RepBoard> findByWord(String word, int currentPage) throws FindException{
		String url = "/board/search/"+word;
		int totalCnt = dao.findCount(word);
		List<RepBoard> list = dao.findByWord(word, currentPage, PageDTO.CNT_PER_PAGE);
		PageDTO<RepBoard> pageDTO = new PageDTO<>(url, currentPage, totalCnt, list);
		
		logger.info("dao.findCount("+word+")=" + totalCnt+", startPage=" +  pageDTO.getStartPage()+", endPage="+  pageDTO.getEndPage() + ", totapPage=" + pageDTO.getTotalPage());
		return pageDTO;
	}
	
	public RepBoard findByNo(int boardNo) throws FindException{
		try {
			dao.plusViewCount(boardNo);//작성, 테스트하세요
			RepBoard rb = dao.findByNo(boardNo);
			return rb;
		} catch (ModifyException e) {
			e.printStackTrace();
			throw new FindException("조회수 증가실패: " + e.getMessage());
		}
	}
	public void modify(RepBoard repBoard) throws ModifyException{
		dao.modify(repBoard);
	}
	public void remove(RepBoard repBoard) throws RemoveException{
		dao.remove(repBoard);
	}
}