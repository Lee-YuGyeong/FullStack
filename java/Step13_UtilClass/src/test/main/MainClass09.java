package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * HashSet은 Set 인터페이스를 구현한 클래스이다.
 * 
 * - 순서가 없다.
 * - key 값도 없다
 * - 중복을 허용하지 않는다.
 * - 어떤 데이터를 중복 없는 묶음(집합) 으로 관리하고자 할때 사용된다.
 */
public class MainClass09 {
	public static void main(String[] args) {
		
		Set<String> set1 = new HashSet<>();
		
		//데이터 추가
		set1.add("김구라");
		set1.add("해골");
		set1.add("원숭이");
		set1.add("원숭이"); //중복불가

		boolean result = set1.contains("해골"); //true
		
		boolean isDelete = set1.remove("원숭이"); // 삭제를 시도하고 성공여부를 리턴
		
		int size = set1.size();
		
		//반복자 객체를 얻어낸다.
		Iterator<String> it = set1.iterator();
		//반복문 돌면서
		while(it.hasNext()) {
			//아이템을 하나씩 불러내서 출력하기
			String item = it.next();
			System.out.println(item);
		}
	}
}
