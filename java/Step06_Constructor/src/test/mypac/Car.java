package test.mypac;

public class Car {
   //필드 정의하기
   public Engine engine;
   
   //객체를 new(생성) 할때 호출되는 생성자
   public Car() {
      System.out.println("Car() 생성자 호출됨");
   }
   // Engine 객체를 인자로 전달 받는 생성자 
   public Car(Engine engine) {
      //지역변수에 담긴 값을 필드에 저장하기 
      this.engine = engine;
   }
   
   //달리는 메소드
   public void drive() {
      if(this.engine==null) {
         System.out.println("Engine 이 없어서 달릴수가 없어요!");
         return; //메소드를 여기서 끝내기 
      }
      System.out.println("신나게 달려요~");
   }
}