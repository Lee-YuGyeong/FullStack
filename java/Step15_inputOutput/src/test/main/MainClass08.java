package test.main;

import java.io.File;

public class MainClass08 {
	public static void main(String[] args) {
		File cDrive = new File("c:/");
		//c 드라이브에 각각의 폴도나 파일을 제어 할 수 있는 객체의 참조값을 배열로 얻어내기
		File[] files = cDrive.listFiles();
		for(File tmp:files) {
			//만일 디렉토리라면
			if(tmp.isDirectory()) {
				System.out.println("<DIR>\t"+tmp.getName());
			}else {
				System.out.println("     \t"+tmp.getName());
			}
		}
		
	}
}
