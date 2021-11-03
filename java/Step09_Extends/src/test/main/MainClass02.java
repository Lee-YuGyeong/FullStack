package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass02 {
	public static void main(String[] args) {
		//Phone 클래스로 객체를 생성해서 참조값을 2가지 type의 지역변수에 담기
		Phone p1 = new Phone();
		Object p2 = new Phone();
		// 객체는 사용설명서
		
		//HandPhone 클래스로 객체를 생성해서 참조값을 3가지 type의 지역변수에 담기
		HandPhone p3 = new HandPhone();
		Phone p4 = new HandPhone();
		Object p5 = new HandPhone();
		
		//이미 만들어진 객체의 참조값을 다른 type 변수를 만들어서 담아보기
		Phone p6 = p3;
		Object p7 = p3;
		
	}
}
