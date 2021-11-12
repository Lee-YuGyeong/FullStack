package test.main;

import java.awt.dnd.DnDConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.util.DBConnect;

public class MainClass12 {
	public static void main(String[] args) {
		
	}
	public static boolean insert() {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 

			//sql 문 실행하기 (INSERT, UPDATE, DELETE)
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		if (flag > 0) {
			//성공
			return true;
		} else {
			//실패
			return false;
		}
	}
}
