package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 *  List는 javascript에서 []와 유사
 *  Map은 javascript에서 {}와 유사
 *  
 *  List<String>은 javascript 에서["aaa","bbb","ccc",..] 와 유사
 *  List<Integer>은 javascript 에서[10,20,30,40,..] 와 유사
 *  List<Map>은 javascript 에서[{},{},{}, ,..] 와 유사
 */
public class MainClass11 {
	public static void main(String[] args) {
		//String type을 저장할 수 있는 ArrayList 객체 생성해서 참조값을  msgs라는 지역변수에 담아보세요.
		List<String> msgs = new ArrayList<>();
		//msgs에 아무거나 문자열 2개를 담아보세요.
		msgs.add("안녕");
		msgs.add("안녕하세요");
		
		
		// Map<String,Object> type 을 저장할수 있는 ArrayList 객체 생성해서 
	  // 참조값을 maps 라는 지역 변수에 담아 보세요.
	  List<Map<String, Object>> maps=new ArrayList<>();
	  //maps 에 두개의 Map 객체를 담아 보세요.
	  //각각의 Map 객체는 회원 한명의 정보를 가지고 있으면 됩니다.
	  Map<String, Object> map1=new HashMap<>();
	  map1.put("num", 1);
	  map1.put("name", "김구라");
	  map1.put("addr", "노량진");
	  
	  Map<String, Object> map2=new HashMap<>();
	  map2.put("num", 2);
	  map2.put("name", "해골");
	  map2.put("addr", "행신동");
	  
	  maps.add(map1);
	  maps.add(map2);

		
      //maps 가변배열에 저장된 값을 이용해서 회원 목록을 아래와 같은 형식으로 
      //반복문을 활용해서 출력 되도록 해 보세요.
      /*
       *  번호 => 1, 이름 => 김구라, 주소 => 노량진
       *  번호 => 2, 이름 => 해골, 주소 => 행신동
       *  .
       *  .
       *  .
       */
		
		for(Map<String,Object> tmp:maps) {
			System.out.println("번호 => "+tmp.get("num") + ", 이름 => "+tmp.get("name")+", 주소 => "+ tmp.get("addr"));
		}

	}
}
