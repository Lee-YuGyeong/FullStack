package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass11 {
   public static void main(String[] args) {
	   MemberDto mem1 = getData(10);
	   List<MemberDto> list = getList();
   }
   //회원 한명의 정보를 select 해서 리턴하는 메소드
   public static MemberDto getData(int num) {
      //필요한 객체를 담을 지역 변수 미리 만들기
      Connection conn=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      //MemberDto 객체의 참조값을 담을 지역변수 
      MemberDto dto=null;
      try {
         //Connection 객체의 참조값 얻어오기 
         conn=new DBConnect().getConn();
         //실행할 sql 문의 뼈대 미리 준비하기
         String sql="SELECT name, addr"
               + " FROM member"
               + " WHERE num=?";
         //PreparedStatement 객체의 참조값 얻어오기
         pstmt=conn.prepareStatement(sql);
         //? 에 필요한값 바인딩하기 
         pstmt.setInt(1, num);
         //select 문 수행하고 결과를 ResultSet 으로 받아오기 
         rs=pstmt.executeQuery();
         while(rs.next()) {
            String name=rs.getString("name");
            String addr=rs.getString("addr");
            //select 된 회원 정보를 MemberDto 객체에 담아서 리턴해준다. 
            dto=new MemberDto();
            dto.setNum(num);
            dto.setName(name);
            dto.setAddr(addr);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();
            if(conn!=null)conn.close();
         } catch (SQLException e) {}
      }
      //select 된 회원 정보가 없으면 null 을 리턴합니다.
      return dto;
   }
   
   //회원 전체 목록을 select 해서 리턴하는 메소드
   public static List<MemberDto> getList(){
      
      //필요한 객체를 담을 지역 변수 미리 만들기
      Connection conn=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      //리턴해줄 객체를 미리 생성해 둔다. 
      List<MemberDto> list=new ArrayList<>();
      try {
         //Connection 객체의 참조값 얻어오기 
         conn=new DBConnect().getConn();
         //실행할 sql 문의 뼈대 미리 준비하기
         String sql="SELECT num,name,addr"
               + " FROM member"
               + " ORDER BY num ASC";
         //PreparedStatement 객체의 참조값 얻어오기
         pstmt=conn.prepareStatement(sql);
         //? 에 필요한값 바인딩하기 
         
         //select 문 수행하고 결과를 ResultSet 으로 받아오기 
         rs=pstmt.executeQuery();
         while(rs.next()) {
            //cursor 가 위치한 곳의 칼럼 데이터를 빼오기 
            int num=rs.getInt("num");
            String name=rs.getString("name");
            String addr=rs.getString("addr");
            //회원정보를 MemberDto 객체를 생성해서 담는다.
            MemberDto dto=new MemberDto();
            dto.setNum(num);
            dto.setName(name);
            dto.setAddr(addr);
            //MemberDto 객체의 참조값을 가변배열에 누적(추가)시킨다 
            list.add(dto);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();
            if(conn!=null)conn.close();
         } catch (SQLException e) {}
      }
      
      return list;
   }
   
   //회원 한명의 정보를 삭제하고 성공 여부를 리턴하는 메소드를 완성해 보세요.
   public static boolean deleteMember(int num) {
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
               + " WHERE num=?";
         //PreparedStatement 객체의 참조값 얻어오기
         pstmt=conn.prepareStatement(sql);
         //? 에 필요한값 바인딩하기 
         pstmt.setInt(1, num);
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
   
   //회원 한명의 정보를 수정하고 성공여부를 리턴하는 메소드를 완성해 보세요.
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
         String sql="UPDATE member"
               + " SET name=?, addr=?"
               + " WHERE num=?";
         //PreparedStatement 객체의 참조값 얻어오기
         pstmt=conn.prepareStatement(sql);
         //? 에 필요한값 바인딩하기 
         pstmt.setString(1, dto.getName());
         pstmt.setString(2, dto.getAddr());
         pstmt.setInt(3, dto.getNum());
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
