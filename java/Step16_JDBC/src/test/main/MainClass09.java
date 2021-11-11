package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass09 {
	public static void main(String[] args) {
		//추가할 회원의 정보를 MemberDto 객체에 담기
		MemberDto dto = new MemberDto();
		dto.setName("이00");
		dto.setAddr("서울");
		//static 메소드를 호출해서 회원 정보를 DB에 저장하기
		MainClass09.insertMember(dto);
		
		MemberDto dto2 = new MemberDto();
		dto2.setName("김00");
		dto2.setAddr("부산");
		
		MainClass09.insertMember(dto2);
	}
	/*
	 * MemberDto 객체를 인자로 전달받아서 DB에 저장하고
	 * 작업의 성공여부를 boolean 으로 리턴해주는 함수
	 */
	public static void insertMember(MemberDto dto) {
		//dto에 담긴 정보를 DB에 저장하는 코드를 작성해보세요!
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문 뼈대 준비하기
			String sql = "INSERT INTO member(num,name,addr) VALUES(member_seq.NEXTVAL,?,?) ";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//?에 필요한값 바인딩하기
			pstmt.setString(1,dto.getName());
			pstmt.setString(2, dto.getAddr());
			//sql 문 실행하기
			pstmt.executeUpdate();
			
			System.out.println("회원 한명의 정보를 저장 했습니다.");
		}catch(Exception e) {
			
		}
		
	}
}
