package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass03 {
	public static void main(String[] args) {
		//1 byte 처리스트림
		InputStream is = System.in;
		//2 byte 처리
		InputStreamReader isr = new InputStreamReader(is);
		//좀더 기능이 향상된 Reader
		BufferedReader br = new BufferedReader(isr);
		
		try {
			System.out.println("문자열 한줄 입력:");
			//문자열 한줄 입력받기
			String line = br.readLine();
			System.out.println("입력한 문자열:"+line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		
		
		
	}
}
