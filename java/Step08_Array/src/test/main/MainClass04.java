package test.main;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		//1. Car type 을 담을 수 있는 방 5개짜리 빈 배열객체를 생성해서 
		// 그 참조값을 cars 라는 이름의 지역변수에 담아 보세요
		Car[] cars = new Car[5];
		//2. 반복문 돌면서 cars 배열의 모든방에 각각다른 Car객체의 참조값을 넣어보세요.
		for(int i=0;i<cars.length;i++) {
			cars[i] = new Car();
		}
		//3. 반복문 돌면서 cars배열안에 있는 Car객체의 참조값을 하나씩 참조해서
		//drive() 메소드를 호출해보세요.
		for(int i=0;i<cars.length;i++) {
			//i 번째 방에 저장된 값을 tmp라는 임시변수에 담기
			Car tmp = cars[i];
			//tmp 안에 있는 참조값을 이용해서 메소드 호출
			tmp.drive();
		}
		System.out.println("확장 for문을 활용하면 아래와 같다.");
		
		for(Car tmp:cars) {
			tmp.drive();
		}
	}
}
