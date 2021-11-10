package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass02 {
	public static void main(String[] args) {
		//1 byte 처리 스트림
		InputStream is = System.in;
		//2 byte 처리 스트림
		InputStreamReader isr = new InputStreamReader(is);
		try {
			System.out.println("입력:");
			//한글의 코드값도 읽어들일 수 있다.
			int code = isr.read();
			System.out.println("code:"+code);
			//코드값에 대응되는 문자 얻어내기
			char ch = (char)code;
			System.out.println("char:"+ch);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
