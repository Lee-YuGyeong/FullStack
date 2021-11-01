package test_main;

import test.mypac.Member;

public class MainClass07 {
   public static void main(String[] args) {
      Member mem1=new Member();
      mem1.showInfo();
      
      System.out.println();
      
      Member mem2=new Member();
      //Member 객체의 필드를 직접 참조해서 값 대입하기 
      mem2.num=1;
      mem2.name="김구라";
      mem2.addr="노량진";
      mem2.showInfo();
      
      System.out.println();
      
      Member mem3=new Member(2, "해골", "행신동");
      mem3.showInfo();
   }
}


