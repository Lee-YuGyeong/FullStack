package pack.business;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.model.SangpumDto;
import pack.resource.SqlMapConfig;

@Repository
public class SangpumImpl implements SangpumInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<SangpumDto> selectAll() {
		SqlSession session = factory.openSession();
		List<SangpumDto> list = null;
		
		try {
			list = session.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("selectAll err : " + e);
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
}
