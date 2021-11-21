package test.util;
/*
 *  객체를 생성해서 메소드를 호출하면 Connection 객체를 리턴하는 객체를 생성할 클래스 설계하기
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	//Connection 객체의 참조값을 담을 필드 선언 
	private Connection conn;
	
	//생성자에서 Connection 객체를 얻어오는 작업을 한다.
	public DBConnect() {
		
		try {
			//오라클 드라이버 클래스 로딩(OracleDriver 클래스를 사용할 준비를 한다)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB 의 정보
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			//DB 연결 객체의 참조값 얻어와서 필드에 담기 
			conn=DriverManager.getConnection(url, "scott", "tiger");
			//예외가 발생하지 않고 여기까지 실행순서가 진행이되면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Connection 객체를 리턴하는 메소드 
	public Connection getConn() {
		
		return conn;
	}
}
