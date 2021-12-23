package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends SqlSessionDaoSupport {

	@Autowired
	public DataDao(SqlSessionFactory factory) {
		setSqlSessionFactory(factory);
	}
	
	public List<BuserDto> buserList(){
		List<BuserDto> list = getSqlSession().selectList("buserList");
		return list;
	}
	
	public List<JikwonDto> jikwonList(String buser_no){
		return getSqlSession().selectList("jikwonList",buser_no);
	}
	
	
}
