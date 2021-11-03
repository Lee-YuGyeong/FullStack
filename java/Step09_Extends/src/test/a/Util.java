package test.a;


public class Util {
	
	//상속관계의 자식에게만 공개
	protected String version;
	
	protected void init() {
		System.out.println("유틸리티를 초기화 합니다. ");
	}
}

