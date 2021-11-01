package test.main;

public class MainClass01 {
/*
 * [ 기본 data type 의 참조 data type]
 * 
 * byte    : Byte
 * short   : Short
 * int     : Integer
 * long    : Long
 * float   : Float
 * double  : Double
 * char    : Character
 * boolean : Boolean
 */
	
	public static void main(String[] args) {
		int num1=10;
		/*
		 * num2에는 참조값이 들어있지만(메소드를 사용할 수 있다)
		 * 10이라는 기본데이터 type이 들어있다고 생각해도된다.
		 */
		Integer num2=10;
		

		//참조 데이터 type 이지만 기본 데이터 type처럼 사용할 수 있다.
		int result = num2 + 1;
		int result2 = num1 + num2;
		Integer result3 = num1 + num2;
		
		//숫자를 문자로 바꾸기 10=>"10"
		String strNum = num2.toString();
		
		//문자를 숫자로 바꾸기
		String strNum2 = "999";
		int result4 = Integer.parseInt(strNum2);
	}
}
