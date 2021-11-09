package test.mypac;

import java.util.Random;
/*
 * 직접 예외(Exception)을 발생 시키는 방법
 * 
 * throw 예외 객체 생성 ;
 */
public class StudyUtil {
	
	
	//공부하는 메소드
	public static void study() throws SleepyException {
		//랜덤한 숫자를 얻어내서
		Random ran = new Random();
		int ranNum = ran.nextInt(3);
		//우연히 0이 나오면 예외를 발생시키기
		if(ranNum==0) {
			throw new SleepyException("너무 졸려서 공부를 할 수가 없어요!");
		}
		System.out.println("열심히 공부합니다!!");
	}
}
