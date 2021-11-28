package test.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.member.dto.MemberDto;
import test.util.DbcpBean;

/*
 * Application 전역에서 MemberDto 객체는 오직 하나만 생성되도록 클래스의 구조 만들기
 * 
 * 1. 생성자의 접근 지정자를 private로 만들어서 외부에서 객체 생성이 되지 않게 한다.
 * 2. 자신의 참조값을 리턴해주는 static 메소드를 제공한다.
 */
public class MemberDao {
	//자신의 참조값을 저장할  static 필드
	private static MemberDao dao;
	
	//1.
	private MemberDao() {}
	//2.
	public static MemberDao getInstance() {
		//만일 최조 호출이라면 
		if(dao==null) {
			//객체를 생성해서 static 필드에 참조값을 저장해둔다.
			dao=new MemberDao();
		}
		//static 필드에 저장된 참조값을 리턴해준다.
		return dao;
	}
	
	//회원 목록을 리턴해주는 메소드 
	public List<MemberDto> getList(){
		//회원 목록을 담을 객체를 미리 생성한다.
		List<MemberDto> list=new ArrayList<>();
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "SELECT num, name, addr"
					+ " FROM member"
					+ " ORDER BY num DESC";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 

			//select 문 수행하고 결과를 ResultSet 으로 받아오기 
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//cursor 가 위치한 곳의 칼럼 데이터를 빼오기 
				//row 하나당 하나의 MemberDto 객체를 생성해서 회원정보를 담고 
				MemberDto dto=new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				//ArrayList 객체에 누적 시킨다.
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
	
	public MemberDto getData(int num) {
		//MemberDto 객체의 참조값을 담을 변수 미리 만들기
		MemberDto dto=null;
		
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "SELECT name, addr"
					+ " FROM member"
					+ " WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 
			pstmt.setInt(1, num);
			//select 문 수행하고 결과를 ResultSet 으로 받아오기 
			rs = pstmt.executeQuery();
			//만일 select 된 row 가 있다면
			if (rs.next()) {
				//cursor 가 위치한 곳의 칼럼 데이터를 빼오기 
				//String name=rs.getString("name");
				//String addr=rs.getString("addr");
				//MemberDto 객체를 생성해서 회원 정보를 담는다.
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
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
					conn.close(); // 자동으로 connection pool에 반납
			} catch (SQLException e) {
			}
		}
		
		return dto;
	}
	
	//회원 정보를 삭제하는 메소드
	public boolean delete(int num) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "DELETE FROM member"
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
			//성공
			return true;
		} else {
			//실패
			return false;
		}

	}
	
	//회원정보를 수정하는 메소드
	public boolean update(MemberDto dto) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "UPDATE member"
					+ " SET name=?, addr=?"
					+ " WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
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
	
	//회원 정보를 추가(입력) 하는 메소드 
	public boolean insert(MemberDto dto) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "INSERT INTO member"
					+ " (num,name,addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
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








