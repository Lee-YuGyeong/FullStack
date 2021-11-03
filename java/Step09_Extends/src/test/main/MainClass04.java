package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass04 {
	public static void main(String[] args) {
		//자식 type 객체를 생성해서 부모 type 지역변수에 대입
		Phone p1 = new SmartPhone();
		
		//부모 type 객체를 자식 type 변수에 담을 때는 casting(형변환) 이 필요하다.
		SmartPhone p2 = (SmartPhone)p1;
		//모든 기능 사용 가능!
		p2.call();
		p2.mobileCall();
		p2.takePicture();
		p2.doInternet();
		
		usePhone(new Phone());
		usePhone(new HandPhone());
		usePhone(new SmartPhone());
	}
	
	public static void usePhone(Phone p) {
		//사용하는 기능은 call() 만 사용한다.
		p.call();
	}
}
