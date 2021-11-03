package test.auto;

public class Car {
   //필드
   public Engine engine;
   //생성자
   public Car(Engine engine) {
      //생성자의 인자로 전달된 객체의 참조값을 필드에 저장하기 
      this.engine=engine;
   }
   //메소드
   public void drive() {
      if(this.engine == null) {
         System.out.println("Engine 객체가 없어서 달릴수가 없어요");
         return; //메소드 끝내기
      }
      System.out.println("달려요!");
   }
}