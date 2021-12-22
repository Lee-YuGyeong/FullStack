package pack.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GogekDaoImpl extends SqlSessionDaoSupport implements GogekDaoInter{

	@Autowired
	public GogekDaoImpl(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	@Override
	public ArrayList<GogekDto> getList() {
		return (ArrayList)getSqlSession().selectList("selectList");
	}
	
}
