package test.main;

import java.util.Scanner;

public class MainClass02 {
   public static void main(String[] args) {
      Scanner scan=new Scanner(System.in);
      
      while(true) {
		  System.out.print("숫자 입력 종료(q):");
		  //숫자 형식의 문자열을 입력 받는다. "10" "20" "10.1" 등등
		  String inputNum=scan.nextLine();
		  if(inputNum.equals("q")) {
			  break;
		  }
		  try {
			  //입력한 문자열을 실제 숫자(실수) 로 변환한다.
			  double num=Double.parseDouble(inputNum);
			  //변환한 숫자에 100 을 더하고
			  double result = num+100;
			  //더한 결과 값을 출력한다.
			  System.out.println("입력한 숫자 + 100 :"+result);
		  }catch(NumberFormatException nfe) {
			  System.out.println("제대로된 숫자를 입력 해주세요");
		  }

      }


      System.out.println("main 메소드가 종료 됩니다.");
   }
}