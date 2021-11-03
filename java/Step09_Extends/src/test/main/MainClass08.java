package test.main;

import test.mypac.HandPhone;
import test.mypac.SmartPhone;

public class MainClass08 {
	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 HandPhone type 으로 받기
		HandPhone p1 = new HandPhone();
		
		//SmartPhone 객체를 생성해서 HandPhone type으로 받기
		HandPhone p2 = new SmartPhone();
		
		p1.takePicture();
		p2.takePicture();
	}
}
