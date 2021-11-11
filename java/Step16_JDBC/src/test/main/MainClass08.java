package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.util.DBConnect;

public class MainClass08 {
	public static void main(String[] args) {
		
		int num=3;
		
		//필요한 객체를 담을 지역변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문 뼈대 준비하기
			String sql = "DELETE FROM member where num=? ";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//?에 필요한값 바인딩하기
			pstmt.setInt(1,num);
			//sql 문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원 한명의 정보를 삭제 했습니다.");
			
		}catch(Exception e) {
			
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
	}
}
