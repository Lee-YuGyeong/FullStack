package test.mypac;
/*
 *  메소드는 다중정의(오버로딩) 되어 있는 경우도 있다.
 */
public class Messenger {
	
	public void sendMessage() {
		System.out.println("빈 메세지를 전송합니다.");
	}
	
	public void sendMessage(String msg) {
		System.out.println(msg +" 를 전송합니다." );
	}
	
	public void sendMessage(int num) {
		System.out.println("숫자 "+num+"을 전송합니다.");
		
	}
	
}
