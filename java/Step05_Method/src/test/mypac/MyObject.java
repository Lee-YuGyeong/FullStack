package test.mypac;

/*
 * [ 메소드를 만들때 고려 해야 하는것 ]
 * 
 *    1. 접근 지정자 
 *  2. 리턴 type
 *  3. 메소드명
 *  4. 메소드에 전달해야하는 인자의 갯수와 데이터 type
 */

public class MyObject {
   
   /*
    *  public => 이 메소드는 어디에서든지 접근 가능하다.
    *  void => 이 메소드는 어떤값도 리턴하지 않는다. 
    *  walk => 메소드명
    *  ( ) => 이 메소드는 어떤 값도 전달받지 않는 메소드이다. 
    */
   public void walk() {
      System.out.println("걸음을 걸어요!");
   }
   // int type 을 리턴해주는 메소드 
   public int getNumber() {
      int myNum=10;
      return myNum;
   }
   // 오늘의 인사를 리턴해 주는 메소드 
   public String getGreeting() {
      return "불금 입니다~";
   }
   // DarkTemplar type 을 리턴해주는 메소드
   public DarkTemplar getTemplar() {
      return new DarkTemplar();
   }
   
   //int type 을 메소드의 인자로 전달 받는 메소드
   public void setNum(int num) {
      System.out.println("인자로 전달 받은 num:"+num);
   }
   //String type 을 메소드의 인자로 전달받는 메소드 
   public void setName(String name) {
      System.out.println("인자로 전달받은 name:"+name);
   }
   //DarkTemplar type 을 메소드의 인자로 전달받는 메소드
   public void setTemplar(DarkTemplar templar) {
      System.out.println("setTemplar() 메소드가 호출되었습니다.");
      templar.move();
   }
   
   // int type 과 String type 를 메소드의 인자로 전달받는 메소드
   public void setData(int number, String msg) {
      System.out.println("setData() 메소드가 호출됨");
   }
   
   //String type 과 DarkTemplar type 을 메소드의 인자로 전달 받는 메소드 
   public void setInfo(String target, DarkTemplar tem) {
      System.out.println("setInfo() 메소드가 호출됨");
   }
   
   public void useSome(Radio r,Speaker s) {
	   System.out.println("useSome() 메소드가 호출됨");
   }
}









