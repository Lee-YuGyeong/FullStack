package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass09 {
   public static void main(String[] args) {
      //문자열을 저장할 파일을 만들기 위한 File 객체
      File memoFile=new File("c:/developer/myFolder/memo.txt");
      
      try {
         
         //파일이 이미 만들어 졌는지 여부
         boolean isExist=memoFile.exists();
         if(!isExist) {
            //파일을 만들어준다.
            memoFile.createNewFile();
            System.out.println("memo.txt 파일을 만들었습니다.");
         }
         //파일에 문자열을 출력할 수 있는 객체 생성
         FileWriter fw = new FileWriter(memoFile);
         fw.write("이00\n");
         fw.write("\t김00\n");
         fw.write("\t\t박00");
         fw.flush();//방출하기
         fw.close();//닫아주기(마무리)
         System.out.println("파일에 문자열을 저장했습니다.");
      }catch(IOException ie) {
         ie.printStackTrace();
      }
      
      
   }
}



