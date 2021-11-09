package test.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainClass01 {
   public static void main(String[] args) {
      
      try {
         int count=0;
         //파일에서 byte 알갱이를 읽어들일수 있는 객체 생성 
         FileInputStream fis=new FileInputStream("c:/developer/myFolder/kim1.png");
         //파일에 byte 알갱이를 출력할수 있는 객체 생성
         FileOutputStream fos=new FileOutputStream("c:/developer/myFolder/copied.png");
         //반복문 돌면서 byte 를 읽어들인다.
         while(true) {
            //파일에서 읽어들이기 
            int data=fis.read();
            //만일 더이상 읽을 데이터가 없다면
            if(data == -1)break; //반복문 탈출 
            count++;
            System.out.println("count:"+count+" data:"+data);
            //읽은 데이터를 파일에 출력하기 
            fos.write(data);
         }
         //마무리 작업 
         fis.close();
         fos.close();
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }
}


