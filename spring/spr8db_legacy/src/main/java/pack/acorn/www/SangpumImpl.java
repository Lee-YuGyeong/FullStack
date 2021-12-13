package pack.acorn.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

//@Component
@Repository	//현재 클래스는 DB처리용 클래스임을 어노테이션 이름으로 짐작이 가능. 가독성 향상
public class SangpumImpl implements SangpumInter {
	// 전통적인 방법의 DB 연결 및 처리
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public SangpumImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("SangpumImpl err : " + e);
		}
	}

	public ArrayList<SangpumDto> selectList() {
		ArrayList<SangpumDto> list = new ArrayList<SangpumDto>();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			pstmt = conn.prepareStatement("select * from sangdata");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SangpumDto dto = new SangpumDto();
				
				dto.setCode(rs.getString("code"));
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("selectList err : " + e);
		}finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

}
