package test.main;
/*
 *  RuntimeException 을 상속 받지 않는 Exception 은 
 *  반드시 try ~ catch 블럭으로 묶어서 예외 처리를 해야한다. 
 */
public class MainClass05 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");

		try {
			//스레드 ( 작업단위, 실행순서 ) 5초 잡아두기
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main 메소드가 종료됩니다.");
	}
}
