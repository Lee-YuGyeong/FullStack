package pack.model;

import java.util.ArrayList;

import pack.controller.BoardBean;

public interface BoardDaoInter {
	ArrayList<BoardDto> getList();
	ArrayList<BoardDto> getSearch(BoardBean bean);
	
	BoardDto getDetail(String num);
	boolean insert(BoardBean bean);
	boolean update(BoardBean bean);
	boolean delete(String num);
	
	int currentMaxnum();
	int totalCnt();
	boolean updateReadcnt(String num);
	String selectPass(String num);
	
	boolean updateOnum(BoardBean bean);
	boolean insertReply(BoardBean bean);
}
