package test.main;

import java.io.File;

public class MainClass07 {
	public static void main(String[] args) {
		//new File("새로 만들거나 제어하고 싶은 파일이나 폴더의 경로")
		File f = new File("c:/");
		String[] names = f.list();
		//배열에 있는 내용을 반복문 돌면서 콘솔창에 모두 출력할 수 있을까요?

		for(int i=0;i<names.length;i++) {
			String tmp = names[i];
			System.out.println(tmp);
		}
		System.out.println("확장 for 문을 이용하면");
		for(String tmp:names) {
			System.out.println(tmp);
		}
	}
}
