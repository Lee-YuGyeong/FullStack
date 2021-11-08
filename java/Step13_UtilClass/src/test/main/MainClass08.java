package test.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainClass08 {
	public static void main(String[] args) {
		//key's Generic => String, value's Generic => String
		Map<String,String> dic = new HashMap<>();
		dic.put("cat","고양이");
		dic.put("dog","강아지");
		dic.put("house","집");
		dic.put("run","달리다");
		dic.put("phone","전화기");
		
		//key 값의 집합을 Set로 얻어내기
		Set<String> keys = dic.keySet();
		//Set 안에 저장된 아이템을 일렬로 세운 반복자 객체 얻어내기
		Iterator<String> it = keys.iterator();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("찾을 value 값을 입력하세요 : ");
		String line = scanner.nextLine();
		
		//결과 key 값을 담을 변수
		String resultKey = null;
		
		//저장된 아이템이 있는 동안에 반복문 돌면서 아이템을 빼낸다.
		while(it.hasNext()) {
			String key = it.next();
			//키값을 이용해서 value 값을 읽어온다.
			String value = dic.get(key);
			//만약 value가 입력한 문자열과 같으면
			if(value.equals(line)) {
				resultKey = key;
			}
			
		}
		if(resultKey!=null) {
			System.out.println("key 값 : " + resultKey);
		}else {
			System.out.println("해당 value는 저장되지 않았습니다.");
		}
	}
}
