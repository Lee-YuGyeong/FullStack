package test.main;

import java.util.Scanner;

public class MainClass01 {
   public static void main(String[] args) {
      Scanner scan=new Scanner(System.in);
      System.out.print("숫자 입력:");
      //숫자 형식의 문자열을 입력 받는다. "10" "20" "10.1" 등등
      String inputNum=scan.nextLine();
      try {
    	//입력한 문자열을 실제 숫자(실수) 로 변환한다.
          double num=Double.parseDouble(inputNum);
          //변환한 숫자에 100 을 더하고
          double result = num+100;
          //더한 결과 값을 출력한다.
          System.out.println("입력한 숫자 + 100 :"+result);
      }catch(NumberFormatException nfe) { //NumberFormatException type의 예외가 발생하면
    	  //실행되는 블럭
    	  
    	  //예외 정보를 콘솔에 출력하기
    	  nfe.printStackTrace();
      }
      
      System.out.println("main 메소드가 종료 됩니다.");
   }
}