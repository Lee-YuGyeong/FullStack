package test.main;

import java.io.File;
import java.io.IOException;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * 특정 파일이나 폴더를 만들거나 제어할 수 있는 File 객체 생성
		 */
		File f1 = new File("C:/developer/myFolder/test.txt");
		
		try {
			boolean isSuccess = f1.createNewFile();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main 메소드가 종료됩니다.");
		
	}
}
