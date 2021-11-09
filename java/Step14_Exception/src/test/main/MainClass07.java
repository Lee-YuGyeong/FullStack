package test.main;

import test.mypac.SleepyException;
import test.mypac.StudyUtil;

public class MainClass07 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		
		try {
			StudyUtil.study();
		} catch (SleepyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
