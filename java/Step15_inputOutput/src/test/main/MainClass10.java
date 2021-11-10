package test.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass10 {
	public static void main(String[] args) {
		File memoFile = new File("c:/developer/myFolder/memo.txt");
		try {
			if(!memoFile.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return; //메소드 끝내기
			}
			//파일에서 문자열을 읽어들일 객체
			FileReader fr = new FileReader(memoFile);
			//무한 루프 돌면서
			while(true) {
				//글자의 코드값을 하나씩 읽어온다.
				int code = fr.read();
				//더이상 읽을게 없다면 반복문 탈출
				if(code==-1) break;
				//코드값에 해당하는 char 값 얻어내기
				char ch = (char) code;
				//콘솔에 한글자씩 출력하기
				System.out.print((char)code);
				
			}
			
			
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}
