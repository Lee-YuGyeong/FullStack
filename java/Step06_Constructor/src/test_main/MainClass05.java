package test_main;
import java.util.Random;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * run 했을때 1~45 사이의 랜덤한 정수를 하나 얻어내서
		 * 콘솔창에 출력하는 프로그래밍을 해보세요
		 */
		
		Random random = new Random();
		int num = random.nextInt(45)+1;
		System.out.println(num);
		
	}
}
