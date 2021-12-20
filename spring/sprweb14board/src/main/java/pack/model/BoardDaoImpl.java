package pack.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDaoInter {

	@Autowired
	public BoardDaoImpl(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}

	@Override
	public ArrayList<BoardDto> getList() {
		// 전체 자료 읽기
		return (ArrayList)getSqlSession().selectList("selectList");
	}

	@Override
	public ArrayList<BoardDto> getSearch(BoardBean bean) {
		// 검색
		return (ArrayList)getSqlSession().selectList("searchList",bean);
	}

	@Override
	public BoardDto getDetail(String num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean insert(BoardBean bean) {
		// 새글 입력
		int re = getSqlSession().insert("insertData",bean);
		if(re > 0) return true;
		else return false;
	}
	
	@Override
	public boolean update(BoardBean bean) {
		// 
		return false;
	}
	
	@Override
	public boolean delete(String num) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int currentMaxnum() {
		// insert시 번호 자동 증가를 위해 현재  테이블에서 가장 큰 번호 얻기

		if(getSqlSession().selectOne("currentMaxnum") == null) return 0;
		
		return getSqlSession().selectOne("currentMaxnum");
	}
	
	@Override
	public int totalCnt() {
		// paging 처리를 위해 전체 레코드 건수 얻기
		return getSqlSession().selectOne("totalCnt");
	}
}
