package test.main;

import test.mypac.Car;

public class MainClass01{
	public static void main(String[] args) {
		//Car 클래스로 객체를 생성하고 그 참조값을  car1이라는 car type 지역변수에 담기
		Car car1 = new Car();
		//car1 객체의 name이라는 필드에 저장된 값을 a라는 이름의 String type 지역변수에 담기
		String a = car1.name;
		//car1 객체의 drive라는 메소드 호출하기
		car1.drive();
	}
}
