package test.main;

public class MainClass11 {
	public static void main(String[] args) {
		
		int count=0;
		// 외형을 보면 무한 루프이지만
		while(true) {
			count++;
			System.out.println(count+"번 반복중...");
			//탈출 조건이 있다.
			if(count==100000) {
				break; // 인접한 반복문 블럭 1개 탈출
			}
		}
		
		System.out.println("main 메소드가 종료됩니다.");
		
	}
}
