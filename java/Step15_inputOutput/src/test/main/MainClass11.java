package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass11 {
	public static void main(String[] args) {
		File memoFile = new File("c:/developer/myFolder/memo.txt");
		try {
			if(!memoFile.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return; //메소드 끝내기
			}
			//파일에서 문자열을 읽어들일 객체
			FileReader fr = new FileReader(memoFile);
			//BufferedReader 객체를 활용해서 작업해 보세요.
			BufferedReader br = new BufferedReader(fr);
			//무한 루프 돌면서
			while(true) {
				//문자열을 한줄씩 읽어들인다.
				String line = br.readLine(); // 줄단위로 읽어오면서 개행기호 빼고 읽어온것 println 해주어야함
				//더이상 읽을 데이터가 업다면
				if(line==null) break; // 반복문 탈출
				System.out.println(line);
			}

			
			
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}
