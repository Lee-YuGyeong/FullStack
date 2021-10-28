package test.mypac;
/*
 * [클래스의 용도]
 * 
 * 1. 데이터 type 의 역할을 한다.
 * 2. 객체의 설계도 역할을 한다.
 * 3. static 필드나 static 메소드를 감싸는(boxing 하는) 역할
 */
public class Car {

	public String name;
	public String brand;
	public void drive() {
		System.out.println("부릉부릉 달려요!");
	}
	public void showBrand() {
		/*
		 * [ this에 대한 이해 ]
		 * 
		 * 클래스 설계 단계에서는 잘 모르겠지만 이 클래스로 객체를 생성했을때
		 * 할당 받는 바로 자신의 객체의 참조값을 가리킨다.
		 * 
		 */
		System.out.println(this.brand);
		
	}
	
}
