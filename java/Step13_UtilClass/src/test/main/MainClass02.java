package test.main;
import java.util.ArrayList;
import java.util.List;

public class MainClass02 {
	public static void main(String[] args) {
		//정소를 저장할 수 있는  List type의 참조값 얻어내기
		List<Integer> nums = new ArrayList<>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		nums.add(10);
		
		//인덱스를 활용한 삭제
//		nums.remove(1);
		
		//참조값을 활용한 삭제
//		Integer value = 20;
//		nums.remove(value);
		nums.remove(new Integer(20));
		
//		int size = nums.size();
//		int num1 = nums.get(0);
//		Integer num2 = nums.get(1);
//		nums.set(1, 40);
//		nums.remove(1);
//		nums.clear();
		
		List<String> names = new ArrayList<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		
		names.remove(1); // 인덱스를 활용한 삭제
		names.remove("해골"); // 참조값(키값)을 활용한 삭제
		

	}
}
