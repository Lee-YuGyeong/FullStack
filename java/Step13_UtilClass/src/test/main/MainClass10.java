package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class MainClass10 {
   public static void main(String[] args) {
      /*
       *  로또번호 1~45 중의 숫자중 랜덤하게 6개를 중복 없이 얻어내서 콘솔창에 출력하는 프로그래밍을 해
       *  보세요. 
       */
      
      //랜덤한 숫자를 얻어낼 객체
      Random ran=new Random();
      //랜덤한 숫자를 저장할 객체
      Set<Integer> lottoSet=new HashSet<>();
      
      while(true) {
         //1 ~ 45 사이의 랜덤한 숫자 얻어내기 
         int ranNum=ran.nextInt(45)+1;
         //얻어낸 숫자를 Set 에 저장하기 
         lottoSet.add(ranNum);
         //만일 lottoSet 의 size 가 6 이면 반복문 탈출 
         if(lottoSet.size() == 6) {
            break;
         }
      }
      
      Iterator<Integer> it=lottoSet.iterator();
      while(it.hasNext()) {
         int num=it.next();
         System.out.print(num+",");
      }
   
   }
}







