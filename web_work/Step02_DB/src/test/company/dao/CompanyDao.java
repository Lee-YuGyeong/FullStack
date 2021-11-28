package test.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.company.dto.CompanyDto;
import test.util.DbcpBean;


public class CompanyDao {
	
	//자신의 참조값을 저장할  static 필드
	private static CompanyDao dao;
	
	//1.
	private CompanyDao() {}
	//2.
	public static CompanyDao getInstance() {
		//만일 최조 호출이라면 
		if(dao==null) {
			//객체를 생성해서 static 필드에 참조값을 저장해둔다.
			dao=new CompanyDao();
		}
		//static 필드에 저장된 참조값을 리턴해준다.
		return dao;
	}
	
	
	public boolean insert(CompanyDto dto) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "INSERT INTO company"
					+ " (empno,ename,job,hiredate)"
					+ " VALUES(company_seq.NEXTVAL,?,?,SYSDATE)";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 
			pstmt.setString(1, dto.getEname());
			pstmt.setString(2, dto.getJob());
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
	
	public boolean update(CompanyDto dto) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "UPDATE Company"
					+" SET ename=?, job=?"
					+" WHERE empno=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 
			pstmt.setString(1, dto.getEname());
			pstmt.setString(2, dto.getJob());
			pstmt.setInt(3, dto.getEmpno());
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
	
	public boolean delete(CompanyDto dto) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "DELETE FROM Company"
					+" WHERE empno=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 
			pstmt.setInt(1, dto.getEmpno());
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
	
	public CompanyDto getData(int empno) {
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CompanyDto dto = null;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "SELECT ename, job, TO_CHAR(hiredate,'YYYY.mm.dd') as hiredate"
					+" FROM Company"
					+ " WHERE empno = ?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 
			pstmt.setInt(1, empno);
			//select 문 수행하고 결과를 ResultSet 으로 받아오기 
			rs = pstmt.executeQuery();
			if (rs.next()) {
				//cursor 가 위치한 곳의 칼럼 데이터를 빼오기
				dto = new CompanyDto();
				dto.setEmpno(empno);
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setHiredate(rs.getString("hiredate"));
				
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
	
	public List<CompanyDto> getList(){
		//필요한 객체를 담을 지역 변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CompanyDto> list = new ArrayList<>();
		
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DbcpBean().getConn();
			//실행할 sql 문의 뼈대 미리 준비하기
			String sql = "SELECT empno, ename, job, TO_CHAR(hiredate,'YYYY.mm.dd') as hiredate"
					+" FROM Company";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 필요한값 바인딩하기 

			//select 문 수행하고 결과를 ResultSet 으로 받아오기 
			rs = pstmt.executeQuery();
			while (rs.next()) {
				//cursor 가 위치한 곳의 칼럼 데이터를 빼오기 
				CompanyDto dto = new CompanyDto();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setHiredate(rs.getString("hiredate"));
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
	
}
