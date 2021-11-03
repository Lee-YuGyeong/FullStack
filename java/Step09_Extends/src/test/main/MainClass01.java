package test.main;

import test.mypac.HandPhone;

public class MainClass01 {
	public static void main(String[] args) {
		HandPhone p1 = new HandPhone();
		//상속받은 부모클래스(phone)에 있는 메소드도 사용가능
		p1.call();
		p1.mobileCall();
		
	}
}
