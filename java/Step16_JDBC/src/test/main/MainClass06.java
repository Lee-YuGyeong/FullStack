package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
		//수정할 회원의 정보(1번 회원의 이름을 이00로 바꾸고싶다면)
		int num=1;
		String name = "이00";
		
		//필요한 객체를 담을 지역변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문 뼈대 준비하기
			String sql = "UPDATE member SET name = ? where num=? ";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//?에 필요한값 바인딩하기
			pstmt.setString(1, name);
			pstmt.setInt(2, num);
			//sql 문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원 한명의 정보를 수정 했습니다.");
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
	}
}
