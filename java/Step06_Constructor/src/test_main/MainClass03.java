package test_main;

import java.util.Scanner;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		/*
		 * Scanner 객체를 생성하면서 생성자의 인자로 System.in을 전달해서 생성한다.
		 * System 클래스의 static 필드 in에는 키보드로부터 입력받을수 있는 객체의
		 * 참조값이 들어있다.
		 */
		Scanner scan = new Scanner(System.in); 
		System.out.print("문자열 입력:");
		String line = scan.nextLine();
		System.out.println("입력 받은 문자열" + line);
		
		System.out.println("종료");
		
	}
}
