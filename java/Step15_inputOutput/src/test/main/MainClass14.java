package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainClass14 {
	public static void main(String[] args) {
		
		System.out.print("파일에 저장할 문자열을 입력해주세요 : ");
		
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		
		File file = new File("c:/developer/myFolder/quiz.txt");
		
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file);
			fw.write(line);
			fw.flush();
			fw.close();
			System.out.println("파일에 문자열이 저장되었습니다.");
		}catch(IOException ie) {
			ie.printStackTrace();
		}

		
		
		
		
	}

}
