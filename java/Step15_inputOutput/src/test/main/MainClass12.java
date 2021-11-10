package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//11마무리작업 더한거
public class MainClass12 {
   public static void main(String[] args) {
      
      File memoFile=new File("c:/developer/myFolder/memo.txt");
      //필요한 객체의 참조값을 담을 변수를 미리 만들어준다.
      FileReader fr=null;
      BufferedReader br=null;
      try {
         if(!memoFile.exists()) {
            System.out.println("파일이 존재 하지 않습니다.");
            return;//메소드 끝내기 
         }
         //객체의 참조값을 얻어내서 미리 만들어둔 변수에 대입한다. 
         fr=new FileReader(memoFile);
         br=new BufferedReader(fr);
         
         //무한 루프 돌면서 
         while(true) {
            //문자열을 한줄씩 읽어 들인다.
            String line=br.readLine();
            //더이상 읽을 데이터가 없다면
            if(line == null)break;//반복문 탈출
            System.out.println(line);
         }
         
      }catch (IOException ie) {
         ie.printStackTrace();
      }finally {//예외 발생과 상관 없이 반드시 실행이 보장되는 블럭
         //마무리 작업을 한다 (보통 열었던 스트림 객체를 닫는 작업을 한다)
         try {
            if(fr!=null)fr.close();
            if(br!=null)br.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }
}





