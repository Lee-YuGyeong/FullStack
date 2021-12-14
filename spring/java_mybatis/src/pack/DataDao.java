package pack;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pack.resource.SqlMapConfig;

//순수 자바에서 MyBatis를 적용하기
public class DataDao {
	private static DataDao instance = new DataDao();
	
	public static DataDao getInstance() {
		return instance;	//singleton pattern 사용
	}
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	//전체 읽기
	public List<SangpumDto> selectAll() throws SQLException{
		SqlSession session = factory.openSession();
		List<SangpumDto> list = session.selectList("selectDataAll");	//DataMapper.xml의 id를 지적 가능
		session.close();
		return list;
	}
	
	//부분 읽기
	public SangpumDto selectBubun(String sbs) throws SQLException{
		SqlSession session = factory.openSession();
		SangpumDto dto = session.selectOne("selectDataById", sbs);
		session.close();
		return dto;
	}
	
	//추가
	public void insData(SangpumDto dto) throws SQLException{
		/*
		SqlSession session = factory.openSession();		//commit이 수동
		//int re = session.insert("insertData", dto);
		//System.out.println(re);
		session.insert("insertData", dto);
		session.commit();    //session.rollback();
		session.close();
		*/
		
		SqlSession session = factory.openSession(true);		//commit이 자동
		session.insert("insertData", dto);
		session.close();
		
		
	}
	
	//수정
	public void upData(SangpumDto dto) throws SQLException{
		SqlSession session = factory.openSession(true);		//commit이 자동
		session.update("updateData", dto);
		session.close();
	}
	
	//삭제
	public int delData(String code) {
		int result=0;
		SqlSession session = factory.openSession();		//commit이 수동
		
		try {
			result = session.delete("deleteData",code);
			session.commit();
		} catch (Exception e) {
			System.out.println("delData err : "+e);
			session.rollback();
		} finally {
			if(session !=null) session.close();
		}
		
		return result;
	}
	
}
