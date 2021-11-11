package test.main;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
//		MemberDto dto = new MemberDto();
//		dto.setNum(1);
//		dto.setName("박00");
//		boolean isSuccess = MainClass11.updateMember(dto);
//		if(isSuccess) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
		
		MemberDto dto2 = new MemberDto();
		dto2.setNum(7);
		boolean isSuccess2 = MainClass11.deleteMember(dto2);
		if(isSuccess2) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	//회원 한명의 정보를 삭제하고 성공여부를 리턴하는 메소드를 완성해보세요.
	public static boolean deleteMember(MemberDto dto) {
	      //dto 에 담긴 정보를 DB 에 저장하는 코드를 작성해 보세요!
	      //필요한 객체를 담을 지역 변수 미리 만들기
	      Connection conn=null;
	      PreparedStatement pstmt=null;
	      int flag=0;
	      try {
	         //Connection 객체의 참조값 얻어오기 
	         conn=new DBConnect().getConn();
	         //실행할 sql 문의 뼈대 미리 준비하기
	         String sql="DELETE FROM member"
	               + " where num=?";
	         //PreparedStatement 객체의 참조값 얻어오기
	         pstmt=conn.prepareStatement(sql);
	         //? 에 필요한값 바인딩하기 
	         pstmt.setInt(1, dto.getNum());
	         //sql 문 실행하기 (INSERT, UPDATE, DELETE)
	         flag=pstmt.executeUpdate();
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(pstmt!=null)pstmt.close();
	            if(conn!=null)conn.close();
	         } catch (SQLException e) {}
	      }
	      //finally 절을 거쳐서 여기까지 실행순서가 왔을때 작업이 성공했는지는 어떻게 알수 있지?
	      if(flag > 0) {
	         //성공
	         return true;
	      }else {
	         //실패
	         return false;
	      }
	}
	//회원 한명의 정보를 수정하고 성공여부를 리턴하는 메소드를 완성해보세요.
	public static boolean updateMember(MemberDto dto) {
	      //dto 에 담긴 정보를 DB 에 저장하는 코드를 작성해 보세요!
	      //필요한 객체를 담을 지역 변수 미리 만들기
	      Connection conn=null;
	      PreparedStatement pstmt=null;
	      int flag=0;
	      try {
	         //Connection 객체의 참조값 얻어오기 
	         conn=new DBConnect().getConn();
	         //실행할 sql 문의 뼈대 미리 준비하기
	         String sql="UPDATE member SET"
	               + " name = ?"
	               + " where num=?";
	         //PreparedStatement 객체의 참조값 얻어오기
	         pstmt=conn.prepareStatement(sql);
	         //? 에 필요한값 바인딩하기 
	         pstmt.setString(1, dto.getName());
	         pstmt.setInt(2, dto.getNum());
	         //sql 문 실행하기 (INSERT, UPDATE, DELETE)
	         flag=pstmt.executeUpdate();
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(pstmt!=null)pstmt.close();
	            if(conn!=null)conn.close();
	         } catch (SQLException e) {}
	      }
	      //finally 절을 거쳐서 여기까지 실행순서가 왔을때 작업이 성공했는지는 어떻게 알수 있지?
	      if(flag > 0) {
	         //성공
	         return true;
	      }else {
	         //실패
	         return false;
	      }
	}
}
