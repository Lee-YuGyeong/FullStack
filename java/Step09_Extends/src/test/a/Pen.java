package test.a;

//public 클래스 접근 지정자는 어디에서든 import 해서 사용할 수 있다.
public class Pen {
	//생성자
	public Pen() {
		
	}
	//비공개 생성자
	private Pen(String color) {
		
	}
	
	//공개 필드
	public String brand;
	
	//비공개 필드
	private String price;
	
	//공개 메소드
	public void test() {
		//Eraser 클래스는 동일 패키지에 존재하기 때문에 import없이 사용 가능하다.
		Eraser a = null;
		
		new Pen(); //가능
		//같은 객체 내부라서 비공개 생성자 호출 가능
		new Pen("파랑"); //가능
		//같은 객체 내부라서 비공개 필드 참조 가능
		System.out.println(this.price);
		//같은 객체 내부라서 비공개 메소드 호출 가능
		this.test2();
	}
	
	//비공개 메소드
	private void test2() {
		
	}
	
}
