package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass01 {
	public static void main(String[] args) {
		//String type을 저장할 수 있는 가변배열객체 생성해서 참조값을 names 라는 지역변수에 담기
		List<String> names = new ArrayList<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");

		//배열의 방의크기
		int size = names.size();
		
		// 0번방에 저장된 내용 참조해서 지역변수에 담아보기
		String name1 = names.get(0);
		String name2 = names.get(1);
		String name3 = names.get(2);
		
		//특정방의 값 수정(덮어 쓰기)	예를 들어 0 번방에 "이정호"를 넣고 싶으면?
		String prevName = names.set(0, "이정호");
		
		
		//특정 인덱스 삭제(방 자체를 제거하기)
		names.remove(0); //1번방 삭제
		names.remove("해골");
		
		System.out.println(names);
		
		//모든방을 다 삭제
		names.clear();

	}
}
