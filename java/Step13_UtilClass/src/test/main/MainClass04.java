package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Member;

public class MainClass04 {
   public static void main(String[] args) {
      // Member type 을 저장할수 있는 ArrayList 객체를 생성해서 참조값을 members 라는
      // 지역변수에 담아 보세요.
      List<Member> members=new ArrayList<>();
      //Member 객체를 하나 생성해서 참조값을 mem1 이라는 지역 변수에 담아 보세요
      Member mem1=new Member();
      // mem1 를 이용해서 회원 한명의 정보를 담아 보세요.
      mem1.num=1;
      mem1.name="김구라";
      mem1.addr="노량진";
      
      //Member 객체를 하나 생성해서 참조값을 mem2 이라는 지역 변수에 담아 보세요
      Member mem2=new Member();
      // mem2 를 이용해서 회원 한명의 정보를 담아 보세요.
      mem2.num=2;
      mem2.name="해골";
      mem2.addr="행신동";
      //mem1 과 mem2 에 들어 있는 참조값을 members 를 이용해서 위에서 생성된 배열(ArrayList)에 저장해 보세요.
      members.add(mem1);
      members.add(mem2);
      
      //아래 코드의 의미를 이해할수 있도록 곰곰히 생각해 보세요~ 
      List<Member> a=members;
      Member b=members.get(0);
      int c=members.get(0).num;
      String d=members.get(0).name;
      String e=members.get(0).addr;
      
      //members 가변배열에 저장된 값을 이용해서 회원 목록을 아래와 같은 형식으로 
      //반복문을 활용해서 출력 되도록 해 보세요.
      /*
       *  번호 => 1, 이름 => 김구라, 주소 => 노량진
       *  번호 => 2, 이름 => 해골, 주소 => 행신동
       *  .
       *  .
       *  .
       */
      for(int i=0; i<members.size(); i++) {
         //i 번째 방의 Member 객체 참조
         Member tmp=members.get(i);
         //출력할 문자열 구성
         String line="번호=>"+tmp.num+" 이름=>"+tmp.name+" 주소=>"+tmp.addr;
         //출력하기
         System.out.println(line);
      }
      
      for(Member tmp:members) {
    	  String line="번호=>"+tmp.num+" 이름=>"+tmp.name+" 주소=>"+tmp.addr;
          System.out.println(line);
      }
   }
}








