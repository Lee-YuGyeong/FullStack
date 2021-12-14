package pack.business;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.model.JikwonDto;
import pack.resource.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<JikwonDto> selectBubun(int[] num) {
		SqlSession session = factory.openSession();
		List<JikwonDto> list = null;
		
		try {
			list = session.selectList("selectDataByBuser", num);
		} catch (Exception e) {
			System.out.println("selectAll err : " + e);
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
}
