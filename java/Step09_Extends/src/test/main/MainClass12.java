package test.main;

import test.a.Pen;

/*
 * [접근 지정자]
 * 
 * public : 어디에서든 접근 가능하다.
 * protected : 같은 package 안에서만 접근 가능하고, package가 달라도 상속관계이면 접근가능
 * default(접근 지정자를 생략) : 같은 package 안에서만 접근 가능 //접근지정자 작성안함
 * private : 같은 클래스 혹은 같은 객체 안에서만 접근 가능
 * 
 * - 접근지정자를 붙이는곳
 * 1. 클래스 (해당 클래스를 import 할 수 있는지 여부를 결정한다)
 * 2. 생성자 (해당 생성자를 호출해서 객체를 생성할 수 있는지 여부를 결정한다)
 * 3. 필드   ( 필드를 참조할 수 있는지 여부를 결정한다)
 * 4. 메소드( 메소드를 호출할 수 있는지 여부를 결정한다)
 * 
 * - 클래스의 접근지정자는 public or default 2가지만 가능하다.
 * 
 */
public class MainClass12 {
	
	public static void main(String[] args) {
		
		//import 가능하기 때문에 Pen type 지역변수를 만드는 것이 가능
		Pen pen1 = null;
		
		// 여기는 test.main 패키지, Eraser 는 test.a. 패키지에 있기 때문에 import 불가
		//Eraser e1 = null;
		
		//default 생성자는 public 으로 공개되어 있어서 객체 생성이 가능하다.
		Pen pen2 = new Pen();
		
		//String type을 전달받는 생성자는 private로 되어있어서 호출불가
		//Pen pen3 = new Pen("노랑");
		
		
		//Pen type 객체의 brand라는 필드는 public 으로 공개되어 있어서 참조 가능
		System.out.println(pen2.brand);
		//Pen type 객체의 price라는 필드는 private 으로 비공개되어 있어서 참조 불가
		//System.out.println(pen2.price);
		
	}
}
