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
		// 상세보기, 글 수정, 댓글에서 사용
		return getSqlSession().selectOne("selectOne",num);	
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
		// 수정 작업
		int re = getSqlSession().update("updateData",bean);
		if(re > 0) return true;
		else return false;
	}
	
	@Override
	public boolean delete(String num) {
		// 삭제 작업
		try {
			int re = getSqlSession().update("deleteData",num);
			if(re > 0) return true;
			else return false;
		} catch (Exception e) {
			return false;
		}
		
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
	
	@Override
	public boolean updateReadcnt(String num) {
		// 상세보기 할 때 조회수 증가용
		int re = getSqlSession().update("updateReadcnt",num);
		if (re>0) return true;
		else return false;
	}
	
	@Override
	public String selectPass(String num) {
		// 수정시 비밀번호 확인
		return getSqlSession().selectOne("selectPass",num);
	}
	
	@Override
	public boolean updateOnum(BoardBean bean) {
		// 댓글에서 onum 갱신
		int re = getSqlSession().update("updateOnum",bean);
		if (re>0) return true;
		else return false;
	}
	
	@Override
	public boolean insertReply(BoardBean bean) {
		// 댓글 등록
		try {
			int re = getSqlSession().insert("insertReData",bean);
			if (re>0) return true;
			else return false;			
		}catch (Exception e) {
			System.out.println("insertReply err : "+e);
			return false;
		}

	}
}
