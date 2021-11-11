
package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass10 {
   public static void main(String[] args) {
         MemberDto dto = new MemberDto();
         dto.setName("누구게");
         dto.setAddr("어디게");
         //회원 정보를 DB에 저장하고 성공여부를 리턴받는다.
         boolean isSuccess = insertMember(dto);
         
         if(isSuccess) {
        	 System.out.println("성공!");
         }else {
        	 System.out.println("실패");
         }
   }
   /*
    *  MemberDto 객체를 인자로 전달받아서 DB 에 저장하고
    *  작업의 성공여부를 boolean 으로 리턴해주는 메소드 
    */
   public static boolean insertMember(MemberDto dto) {
      //dto 에 담긴 정보를 DB 에 저장하는 코드를 작성해 보세요!
      //필요한 객체를 담을 지역 변수 미리 만들기
      Connection conn=null;
      PreparedStatement pstmt=null;
      int flag=0;
      try {
         //Connection 객체의 참조값 얻어오기 
         conn=new DBConnect().getConn();
         //실행할 sql 문의 뼈대 미리 준비하기
         String sql="INSERT INTO member"
               + " (num, name, addr)"
               + " VALUES(member_seq.NEXTVAL, ?, ?)";
         //PreparedStatement 객체의 참조값 얻어오기
         pstmt=conn.prepareStatement(sql);
         //? 에 필요한값 바인딩하기 
         pstmt.setString(1, dto.getName());
         pstmt.setString(2, dto.getAddr());
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

















