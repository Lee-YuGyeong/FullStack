package test.main;
/*
 *  [ Java 참조 데이터 type ]
 *  
 *  1. String
 *  - 문자열을 다룰때 사용하는 데이터 type
 *  
 */
public class MainClass05 {

	public static void main(String[] args) {
		
		// "김구라" 의 참조값을 name이라는 변수에 담기
		String name = "김구라";
		
		String tmp = name;
		name = "원숭이";
		name = null;

		int num1=10;
		num1=20;
		
	}

}
