package test.mypac;
/*
 *  새로운 스레드 만드는 방법2
 *  
 *  1. Runnable 인터페이스를 구현한 클래스를 정의한다.
 *  2. run() 메소드를 강제 오버라이드 한다.
 *  3. Thread 클래스로 객체를 생성하면서 해당클래스로 만든 객체를 생성자의 인자로 전달한다.
 *  4. Thread 클래스로 만든 객체의 start() 메소드를 호출해서 스레드를 시작 시킨다.
 */
public class CountRunnable implements Runnable{

   @Override
   public void run() {
      int count=0;
      while(true) {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         count++; //카운트를 증가 시킨다.
         System.out.println("현재 카운트:"+count);
         if(count==10) break;// 카운트가 10이 되면 반복문 탈출 => run()메소드종료  => 스레드 종료를 의미 
      }
   }

}



