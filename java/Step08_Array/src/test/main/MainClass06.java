package test.main;

import java.util.Scanner;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * Scanner 객체를 이용해서 친구이름을 총 5명 입력받아서
		 * 
		 * 배열에 순서대로 저장하고
		 * 
		 * 반복문 돌면서 배열에 저장된 친구 이름을 순서대로 콘솔창에 입력하는 프로그램밍을 해보세요.
		 * 
		 * [ run 했을때 콘솔의 실행 화면]
		 * 
		 * 이름입력:김구라
		 * 이름입력:해골
		 * 이름입력:원숭이
		 * 이름입력:주뎅이
		 * 이름입력:덩어리
		 * 
		 * 입력한 이름:김구라
		 * 입력한 이름:해골
		 * 입력한 이름:원숭이
		 * 입력한 이름:주뎅이
		 * 입력한 이름:덩어리
		 * 
		 */
		
		Scanner scanner = new Scanner(System.in);
		String[] names = new String[5];
		
		for(int i=0;i<names.length;i++) {
			System.out.print("이름입력:");
			String name = scanner.nextLine();
			names[i] = name;
		}
		
		for(int i=0;i<names.length;i++) {
			System.out.println("입력한 이름:" + names[i]);
		}
		
	}
}
