package test.main;

import java.util.Random;

public class MainClass08 {
   public static void main(String[] args) {
      /*   
       *   hint 
       *   
       *   String[] items={"cherry", "apple", "banana", "melon", "7"};
       *  
       *   2. 5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요.
       *      예)  cherry | apple | cherry
       *           7 | apple | melon
       *           7 | 7 | 7
       *      
       */
      
      //2. 
      String[] items={"cherry", "apple", "banana", "melon", "7"};
      //Random 객체를 생성해서
      Random ran=new Random();
      
      // 랜덤한 정수를 미리 3개 얻어내기 
      int one=ran.nextInt(5);
      int two=ran.nextInt(5);
      int three=ran.nextInt(5);
      
      //출력할 문자열 구성
      String result = items[one] + " | " + items[two] + " | " + items[three]; 
      
      //출력하기
      System.out.println(result);
      
   }
}






