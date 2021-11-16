package test.mypac;
/*
 * 새로운 스레드 만드는 방법
 * 
 * 1. Thread 클래스를 상속 받은 클래스를 정의한다.
 * 2. run() 메소드를 오버라이드한다.
 * 3. run() 메소드 안에서 새로운 스레드에서 해야할 작업을 코딩한다.
 * 4. 만든 클래스로 객체를 생성하고 해당 객체의 start() 메소드를 호출하면 새로운 스레드가 시작된다.
 */
public class DownloadThread extends Thread{

	@Override
	public void run() {
	      //완료하는데 10초가 걸리는 작업을 한다고 가정하자
	      try {
	         Thread.sleep(10000);
	         System.out.println("다운로드가 완료 되었습니다.");
	      } catch (InterruptedException e1) {
	         e1.printStackTrace();
	      }
	}
	

}
