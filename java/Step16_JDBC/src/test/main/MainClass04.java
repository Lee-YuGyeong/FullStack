package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.util.DBConnect;

public class MainClass04 {
   public static void main(String[] args) {


	   
      try {
    	 //DBConnect 객체를 이용해서 Connection 객체의 참조값 얻어오기
    	 Connection conn = new DBConnect().getConn();
         //실행할 sql 문 
         String sql="SELECT ename, deptno, "
               + " TO_CHAR(hiredate,'YYYY.MM.DD') AS hiredate"
               + " FROM emp ORDER BY ename ASC";
         //sql 문을 실행해줄 객체의 참조값 얻어오기
         PreparedStatement pstmt=conn.prepareStatement(sql);
         //query 문 수행하고 결과셋 객체 얻어오기 
         ResultSet rs=pstmt.executeQuery();
         
         while(rs.next()) {
            String ename=rs.getString("ename");
            int deptno=rs.getInt("deptno");
            //String hiredate=rs.getString("TO_CHAR(hiredate,'YYYY.MM.DD')");
            //String hiredate=rs.getString(3);
            String hiredate=rs.getString("hiredate");
            System.out.println(ename+" | "+deptno+" | "+hiredate);
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }
 
      
   }
}









