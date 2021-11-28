package test.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.users.dto.UsersDto;
import test.util.DbcpBean;

public class UsersDao {
   
   private static UsersDao dao;
   private UsersDao() {}
   public static UsersDao getInstance() {
      if(dao==null) {
         dao=new UsersDao();
      }
      return dao;
   }
   
   //회원정보를 DB 에 저장하는 메소드
   public boolean insert(UsersDto dto) {
      //필요한 객체를 담을 지역 변수 미리 만들기
      Connection conn = null;
      PreparedStatement pstmt = null;
      int flag = 0;
      try {
         //Connection 객체의 참조값 얻어오기 
         conn = new DbcpBean().getConn();
         //실행할 sql 문의 뼈대 미리 준비하기
         String sql = "INSERT INTO form_test"
               + " (nick, email, concern, lan, comm)"
               + " VALUES( ?, ?, ?, ?, ?)";
         //PreparedStatement 객체의 참조값 얻어오기
         pstmt = conn.prepareStatement(sql);
         //? 에 필요한값 바인딩하기 
         pstmt.setString(1, dto.getNick());
         pstmt.setString(2, dto.getEmail());
         pstmt.setString(3, dto.getConcern());
         pstmt.setString(4, dto.getLan());
         pstmt.setString(5, dto.getComm());
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
   //인자로 전달되는 nick 을 이용해서 해당회원 한명의 정보를 리턴하는 메소드
   public UsersDto getData(String nick) {
      
      UsersDto dto=null;
      //필요한 객체를 담을 지역 변수 미리 만들기
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         //Connection 객체의 참조값 얻어오기 
         conn = new DbcpBean().getConn();
         //실행할 sql 문의 뼈대 미리 준비하기
         String sql = "SELECT email, concern, lan, comm"
               + " FROM form_test"
               + " WHERE nick=?";
         //PreparedStatement 객체의 참조값 얻어오기
         pstmt = conn.prepareStatement(sql);
         //? 에 필요한값 바인딩하기 
         pstmt.setString(1, nick);
         //select 문 수행하고 결과를 ResultSet 으로 받아오기 
         rs = pstmt.executeQuery();
         while (rs.next()) {
            dto=new UsersDto();
            dto.setNick(nick);
            dto.setEmail(rs.getString("email"));
            dto.setConcern(rs.getString("concern"));
            dto.setLan(rs.getString("lan"));
            dto.setComm(rs.getString("comm"));
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
}






