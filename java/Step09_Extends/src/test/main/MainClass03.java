package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass03 {
	public static void main(String[] args) {
		//SmartPhone 객체를 생성해서 SmartPhone type의 지역변수 p1에 담기
		SmartPhone p1 = new SmartPhone();
		//p1에 담긴 참조값을 HandPhone type 지역변수 p2에 담기
		HandPhone p2 = p1;
		//p1에 담긴 참조값을 Phone type 지역변수 p3에 담기
		Phone p3 = p1;
		//p1에 담긴 참조값을 Object type 지역변수 p4에 담기
		Object p4 = p1;
		
	}
}
