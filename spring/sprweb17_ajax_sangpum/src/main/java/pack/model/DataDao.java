package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//편의상 인터페이스 없이 작업함
@Repository
public class DataDao extends SqlSessionDaoSupport{

	@Autowired
	public DataDao(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	public List<SangpumDto> sangpumList(){
		return getSqlSession().selectList("selectList");
	}
	
}
