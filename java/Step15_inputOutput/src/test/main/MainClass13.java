package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass13 {
   public static void main(String[] args) {
      
      //필요한 객체의 참조값을 담을 지역 변수를 미리 만든다.
      FileInputStream fis=null;
      FileOutputStream fos=null;
      
      try {
         fis=new FileInputStream("c:/developer/myFolder/kim1.png");
         fos=new FileOutputStream("c:/developer/myFolder/kimgura.png");
         //byte 알갱이를 담을 배열 객체를 미리 생성한다.
         byte[] buffer=new byte[1024]; //한번에 1kilo byte 씩 읽어낼수 있다. 
         while(true) {
            /*
             *  .read() 메소드를 호출하면서 byte[] 객체의 참조값을 전달하면
             *  메소드안에서 읽은 byte 데이터가 배열에 자동 저장된다.
             *  또한 읽은 바이트의 갯수를 메소드가 리턴해준다. 
             */
            int readedByte=fis.read(buffer);
            //탈출조건???
            if(readedByte == -1)break;
            //읽은 만큼 파일에 출력하기
            // .write(배열, 시작 인덱스, 출력할 총 갯수)
            fos.write(buffer, 0, readedByte);
         }
         System.out.println("파일을 복사 했습니다.");
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(fis!=null)fis.close();
            if(fos!=null)fos.close();
         }catch(Exception e) {}
      }
      
   }
}








