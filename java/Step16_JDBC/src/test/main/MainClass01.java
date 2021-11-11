package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * JDBC ( Java DataBase Connectivity )
 * 
 * DataBase 에 연결해서 SELECT, INSERT, UPDATE, DELETE 작업하기
 * 
 * Oracle 에 연결하기 위해서는 드라이버 클래스가 들어있는 ojdbc6.jar 파일을
 * 사용할 수 있도록 설정해야한다.
 */
public class MainClass01 {
	public static void main(String[] args) {
		
		try {
			//오라클 드라이버 클래스 로딩(OracleDriver 클래스를 사용할 준비를 한다)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB의 정보
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//DB 연결 객체의 참조값 얻어오기
			Connection conn = DriverManager.getConnection(url, "scott", "tiger");
			//예외가 발생하지 않고 여기까지 실행순서가 진행이되면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공!");
			
			//실행할 sql 문
			String sql = "SELECT empno, ename, sal FROM emp";
			//sql 문을 실행해줄 객체의 참조값 얻어오기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//query문 수행하고 결과셋 객체 얻어오기
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				//empno 라는 칼럼을 정수로 얻어내기
				int empno = rs.getInt("empno");
				//ename 라는 칼럼을 문자열로 얻어내기
				String ename = rs.getString("ename");
				//sal 라는 칼럼을 문자열로 얻어내기
				int sal = rs.getInt("sal");
				System.out.println(empno +" | "+ ename +" | "+ sal);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
