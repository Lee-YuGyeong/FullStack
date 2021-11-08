package test.main;

import test.mypac.Member;

public class MainClass03 {
	public static void main(String[] args) {
		//Member 클래스로 객체를 생성해서 참조값을 mem1 이라는 지역변수에 담아보세요.
		Member mem1 = new Member();
		//mem1 에 들어 있는 참조값을 이용해서 회원 한명의 정보를 저장해 보세요.
	    // 1, "김구라", "노량진"
		mem1.num = 1;
		mem1.name = "김구라";
		mem1.addr = "노량진";
		
	}
}
