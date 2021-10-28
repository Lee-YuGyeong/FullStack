package test.main;

import test.mypac.MyUtil;

public class MainClass04 {
	//프로그램의 시작점, 도입점이 되는 메인 메소드
	public static void main(String[] args) {
		//MyUtil 클래스의 static 필드 참조해서 값 대입해보기
		MyUtil.version="1.0";
		//MyUtil 클래스의 static 메소드 호출하기
		MyUtil.send();
	}
}
