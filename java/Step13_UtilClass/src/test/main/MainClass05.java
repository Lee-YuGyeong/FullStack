package test.main;

import java.util.HashMap;
import java.util.Map;

import test.mypac.Member;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * key : value 형태로 데이터를 저장할 수 있는 HashMap 객체 생성하고 
		 * 참조값을 map1 이라는 지역변수에 저장하기
		 * 
		 * key 의 type은 String 으로 가장 많이 사용한다.
		 * value 의 type은 여러 type을 섞어서 담을거면 Object로 지정하면 된다.
		 *  
		 */
		
		Map<String,Object> map1 = new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("addr", "노량진");
		
		/*
		 * value 의 Generic type을 Object로 했기 떄문에
		 * .get(키값) 메소드는 Object type을 리턴한다.
		 * 
		 * 따라서 제대로 사용하기 위해서는 원래 type으로 casting 해 주어야한다.
		 */
		int num1 = (int)map1.get("num");
		String name1 = (String) map1.get("name");
		String addr1 = (String) map1.get("addr");
		
		
		//특정 key로 저장된 값 삭제하기
		map1.remove("addr");
		//비어있는지 여부
		boolean isEmpty = map1.isEmpty();
		//모두 삭제
		map1.clear();
		
		// 아래의 Member class, Member type 의 사용법과 비교해보기
		
		Member mem1 = new Member();
		mem1.num = 1;
		mem1.name = "김구라";
		mem1.addr = "노량진";
		
		int num2 = mem1.num;
		String name2 = mem1.name;
		String addr2 = mem1.addr;
		
		//삭제 없음
	}
}
