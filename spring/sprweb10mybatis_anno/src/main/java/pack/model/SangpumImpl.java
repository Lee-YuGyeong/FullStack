package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import pack.controller.SangpumBean;


@Repository
public class SangpumImpl implements SangpumInter {	//MyBatis Annotation 사용 시 extends SqlSessionDaoSupport 삭제

	@Autowired
	private SangpumAnnoInter sangpumAnnoInter;
	
	public List list() throws DataAccessException {
		return sangpumAnnoInter.selectDataAll();
	}
	
	@Override
	public List search(SangpumBean bean) throws DataAccessException {
		return sangpumAnnoInter.selectSearch(bean);
	}
	
	
}
