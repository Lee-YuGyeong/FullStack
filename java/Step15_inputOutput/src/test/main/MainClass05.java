package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass05 {
   public static void main(String[] args) {
      //System 클래스의 out 이라는 static 필드에는 콘솔창에 출력할수 있는
      //PrintStream 객체의 참조값이 들어 있다.
      PrintStream ps=System.out;
      //학습을 위해서 PrintStream  객체를 부모 type OutputStream 으로 받아보기
      //OutputStream 도 1byte 처리 스트림이다.
      OutputStream os=ps;
      //2byte 처리 스트림
      OutputStreamWriter osw=new OutputStreamWriter(os);
      
      try {
         osw.write(44032);
         osw.write("오잉???");
         osw.flush();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }
}






