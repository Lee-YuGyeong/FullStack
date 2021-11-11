package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * emp 테이블에서
		 * 사원이름, 부서번호, 입사일을 출력해보세요.
		 * 단, 사원의 이름에 대해서 오름차순 정렬해서 출력
		 */
		
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
			String sql = "SELECT ename, deptno, hiredate FROM emp order by ename";
			//sql 문을 실행해줄 객체의 참조값 얻어오기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//query문 수행하고 결과셋 객체 얻어오기
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				//ename 라는 칼럼을 문자열로 얻어내기
				String ename = rs.getString("ename");
				String deptno = rs.getString("deptno");
				String hiredate = rs.getString("hiredate");
				System.out.println(ename +" | "+ deptno +" | "+ hiredate);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
