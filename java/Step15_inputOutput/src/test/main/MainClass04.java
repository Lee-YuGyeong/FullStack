package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
   public static void main(String[] args) {
      //System 클래스의 out 이라는 static 필드에는 콘솔창에 출력할수 있는
      //PrintStream 객체의 참조값이 들어 있다.
      PrintStream ps=System.out;
      //학습을 위해서 PrintStream  객체를 부모 type OutputStream 으로 받아보기
      //OutputStream 도 1byte 처리 스트림이다.
      OutputStream os=ps;
      
      try {
         //출력은 .flush() 까지 호출해야 출력이 된다.
         os.write(97);
         os.write(98);
         os.write(99);
         //한글 '가' 의 unicode 값이 44032 인데 한글이 출력이 될까???
         //os.write(44032); OutputStream 은 한글 출력 불가
         os.flush(); //방출하기
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }
}






