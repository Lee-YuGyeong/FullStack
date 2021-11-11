package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.util.DBConnect;

public class MainClass05 {
	public static void main(String[] args) {
		//member 테이블에 추가할 이름과, 주소
		String name = "김구라";
		String addr = "노량진";
		
		//필요한 객체를 담을 지역변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문 뼈대 준비하기
			String sql = "INSERT INTO member"
					+" (num,name,addr)"
					+" VALUES(member_seq.NEXTVAL,?,?)";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//?에 필요한값 바인딩하기
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			//sql 문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원 한명의 정보를 추가 했습니다.");
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
	}
}
