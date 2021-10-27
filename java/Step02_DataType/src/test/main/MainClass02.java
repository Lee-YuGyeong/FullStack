package test.main;

public class MainClass02 {
   public static void main(String[] args) {
      //국어 점수
      int kor=95;
      //영어 점수
      int eng=100;
      
      //1. 국어 점수와 영어점수의 평균을 구해서 변수에 담아 보세요.
      
      /*
       *   정수와 정수를 연산하면 결과는 정수만 나온다
       *   정확한 실수값이 필요하면 연산하는 숫자중에 어느 하나라도 실수가 있어야 한다.  
       */
      double ave=(kor+eng)/2.0;
      double ave2=(kor+eng)/(double)2;
      
      //2. 그리고 결과를  콘솔창에 이쁘게 출력해 보세요.
      System.out.println("★평균 점수★는 ※"+ave+"※점입니다랄라♬ :D");
   }
}






