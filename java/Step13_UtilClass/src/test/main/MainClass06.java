package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass06 {
	public static void main(String[] args) {
		//key's Generic => String, value's Generic => String
		Map<String,String> dic = new HashMap<>();
		dic.put("cat","고양이");
		dic.put("dog","강아지");
		dic.put("house","집");
		dic.put("run","달리다");
		dic.put("phone","전화기");

		/*
		 * Scanner 객체를 이용해서 영어단어를 입력 받아서 
		 * 거기에 해당되는 뜻을 dic에서 찾아서 입력한 단어에 대한 뜻을 출력하는 프로그래밍 해 보세요.
		 * 단, 없는 단어이면 존재하지 않는 단어입니다 라고 출력하면됩니다.
		 * 
		 * 실행화면
		 * 
		 * 찾을 단어를 입력하세요 : dog
		 * 뜻 : 강아지
		 * 
		 * 찾을 단어를 입력하세요 :  phone
		 * 뜻 : 전화기
		 * 
		 * 찾을 단어를 입력하세요 :  pen
		 * 존재하지 않는 단어입니다.
		 */
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("찾을 단어를 입력하세요 : ");
		String str = scanner.nextLine();
		if(dic.containsKey(str)) {
			System.out.println("뜻 : "+ dic.get(str));
		}else {
			System.out.println("존재하지 않는 단어입니다.");
		}
	}
}
