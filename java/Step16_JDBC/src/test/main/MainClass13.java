package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass13 {
	public static void main(String[] args) {
		//추가할 회원의 정보라고 가정하자
		String name = "아이폰";
		String addr = "Apple";
		//추가할 회원의 정보를 MemberDto 객체에 담아서
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//MemberDao 객체를 이요해서 DB에 저장하기
		boolean isSuccess = new MemberDao().insert(dto);
		if(isSuccess) {
			System.out.println("회원 정보 추가 성공");
		}
		
		
	}
}
