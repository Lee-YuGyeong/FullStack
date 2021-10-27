package test.main;

public class MainClass08 {
	public static void main(String[] args) {
		int num1=10;
		String str = "abcd12345";
		/*
		 * javascript 에서는 함수를 호출한 그 위치는 반드시 어떤 값으로 바뀌지만
		 * java 에서는 메소드를 호출한 그 위치는 바뀔수도 있고 안바뀔수도 있다.
		 */
		int a = str.length();
		char b = str.charAt(5);
		String c = str.toUpperCase();
		
		System.out.println("문자열 길이: "+a);
		System.out.println("index 5: "+b);
		System.out.println(c);
	}
}
