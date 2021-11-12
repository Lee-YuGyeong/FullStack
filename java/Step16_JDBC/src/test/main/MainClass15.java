package test.main;

import java.util.ArrayList;
import java.util.List;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass15 {
	public static void main(String[] args) {
	      /*
	       *  MemberDao 객체를 이용해서 회원 목록을 얻어와서
	       *  아래와 같은 형식으로 출력해 보세요.
	       *  
	       *  1 | 김구라 | 노량진
	       *  2 | 원숭이 | 상도동
	       *  3 | 주뎅이 | 봉천동
	       *  .
	       *  .
	       */
		List<MemberDto> list = new MemberDao().getList();
		
		for(MemberDto memberDto:list) {
			System.out.println(memberDto.getNum() + " | " + memberDto.getName() + " | " + memberDto.getAddr());
		}
	}
}
