package test.mypac;
/*
 *  [ 생성자 ]
 *  
 *  1. 클래스명과 동일하다
 *  2. 메소드 모양과 유사 하지만 리턴 type  이 없다.
 *  3. 객체를 생성할때(new 할때) 호출된다. 
 *  4. 객체를 생성하는 시점에 무언가 준비 작업을 할때 유용하다.
 *  5. 생성자를 명시적으로 정의 하지 않아도 기본 생성자는 있다고 간주된다. 
 */

public class Member {
   //필드 정의하기
   public int num;
   public String name;
   public String addr;
   
   
   //default 생성자
   public Member() {
      
   }
   /*
    * 생성자의 인자로 int, String, String type 을 전달 받는 생성자
    * default 생성자 이외에  생성자를 하나라도 정의하면 
    * default 생성자는 명시적으로 정의하지 않으면 없다고 간주된다. 
    */
   public Member(int num, String name, String addr) {
      //지역변수 num 에 있는 값을 필드의 num 에 대입하기 
      this.num=num;
      this.name=name;
      this.addr=addr;
   }
   
   //메소드
   public void showInfo() {
      System.out.println("번호:"+this.num+" 이름:"+this.name+" 주소:"+addr);
   }
}













