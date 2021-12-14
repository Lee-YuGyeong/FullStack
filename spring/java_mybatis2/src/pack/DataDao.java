package pack;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.resource.SqlMapConfig;

public class DataDao {
	private static DataDao instance = new DataDao();

	public static DataDao getInstance() {
		return instance; // singleton pattern 사용
	}

	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	public List<JikwonDto> selectBubun(int num[]){
		
		SqlSession session = factory.openSession();
		List<JikwonDto> list = session.selectList("selectDataByBuser", num);
		session.close();
		return list;
	}
	
}
