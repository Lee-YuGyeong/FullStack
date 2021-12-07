package test.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.guestbook.dto.GuestBookDto;
import test.util.DbcpBean;

public class GuestBookDao {
	//필드
	private static GuestBookDao dao;
	//생성자
	private GuestBookDao() {}
	//자신의 참조값을 리턴해주는 static 메소드
	public static GuestBookDao getInstance() {
		if(dao==null) {
			dao=new GuestBookDao();
		}
		return dao;
	}
	//새글을 저장하는 메소드
	public boolean insert(GuestBookDto dto) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "INSERT INTO guest_book"
					+ " (num,writer,title,content,pwd,regdate)"
					+ " VALUES(guest_book_seq.NEXTVAL, ?,?,?,?,SYSDATE)";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getPwd());
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
			return true;
		} else {
			return false;
		}
	}
	//글 목록을 리턴하는 메소드
	public List<GuestBookDto> getList(){
		//글 목록을 담을 ArrayList 객체 생성
		List<GuestBookDto> list=new ArrayList<>();
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "SELECT num,writer,title,content,pwd,regdate"
					+ " FROM guest_book"
					+ " ORDER BY num DESC";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 

			//select 문 수행하고 결과를 ResultSet 으로 받아오기 
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GuestBookDto dto=new GuestBookDto();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPwd(rs.getString("pwd"));
				dto.setRegdate(rs.getString("regdate"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return list;
	}
	//글 하나의 정보를 리턴하는 메소드
	public GuestBookDto getData(int num) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GuestBookDto dto = null;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "SELECT writer,title,content,pwd,regdate"
					+ " FROM guest_book"
					+ " WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 
			pstmt.setInt(1, num);
			//select 문 수행하고 결과를 ResultSet 으로 받아오기 
			rs = pstmt.executeQuery();
			//만일 select된 데이터가 있다면
			if (rs.next()) {
				dto = new GuestBookDto();
				dto.setNum(num);
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPwd(rs.getString("pwd"));
				dto.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return dto;
	}
	//글 하나의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "DELETE FROM guest_book"
					+ " WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 
			pstmt.setInt(1, num);
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
			return true;
		} else {
			return false;
		}
	}
}
