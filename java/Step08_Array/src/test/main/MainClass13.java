package test.main;

import java.util.Random;
import java.util.Scanner;

public class MainClass13 {
   public static void main(String[] args) {
      Scanner scan=new Scanner(System.in);
      while(true) {
         System.out.print("탈출하고 싶으면 q 를 입력하세요:");
         String line=scan.nextLine();
         /*
          *  java 에서 문자열이 같은지 비교할때는 .equals() 메소드를 이용해야 한다.
          */
         if(line.equals("q")) {
            break;
         }
      }
      System.out.println("main 메소드가 종료 됩니다.");
   }
}






4