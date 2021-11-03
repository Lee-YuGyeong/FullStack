package test.mypac;

public class SmartPhone extends HandPhone{

	public SmartPhone() {
	
		System.out.println("SmartPhone() 생성자");
	}
	public void doInternet() {
		System.out.println("인터넷을 해요");
	}
	
	@Override
	public void takePicture() {
		//필요하다면 부모의 메소드도 여기서 super 예약어를 이용해서 호출할수도 있다.
		//super.takePicture();
		
		System.out.println("1000만 화소의 사진을 찍어요");
	}
}
