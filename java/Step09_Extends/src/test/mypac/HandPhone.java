package test.mypac;

//Phone 클래스를 확장해서 HandPhone 클래스를 정의한다.
//Phone 클래스를 상속 받아서 자식클래서 HandPhone을 정의한다.
public class HandPhone extends Phone{
	public HandPhone() {
		// TODO Auto-generated constructor stub
		System.out.println("HandPhone() 생성자");
	}

	//이동중에 전화를 거는 메소드
	public void mobileCall() {
		System.out.println("이동중에 전화를 걸어요!");
	}
	//사진 찍는 메소드
	public void takePicture() {
		System.out.println("30만 화소의 사진을 찍어요");
	}
	
}
