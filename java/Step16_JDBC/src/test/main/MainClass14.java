package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass14 {
   public static void main(String[] args) {
      /*
       *  Scanner 객체를 이용해서 추가할 회원의 이름과 주소를 입력 받아서 
       *  DB 에 저장하는 기능을 구현해 보세요.
       */
      Scanner scan=new Scanner(System.in);
      System.out.print("이름 입력:");
      String name=scan.nextLine();
      System.out.print("주소 입력:");
      String addr=scan.nextLine();
      //추가할 회원의 정보를 MemberDto 객체에 담고 
      MemberDto dto=new MemberDto(0, name, addr);
      //MemberDao 객체를 생성해서
      MemberDao dao=new MemberDao();
      //insert 메소드를 이용해서 추가하기 
      boolean isSuccess=dao.insert(dto);
      if(isSuccess) {
         System.out.println(name+" 님의 정보를 추가 했습니다.");
      }
   }
}










