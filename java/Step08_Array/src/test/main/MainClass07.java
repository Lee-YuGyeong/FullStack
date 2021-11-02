package test.main;

import java.util.Random;
import java.util.Scanner;

public class MainClass07 {
	public static void main(String[] args) {
		
		/*
	       * hint
	       * 
	       * String[] items={"cherry", "apple", "banana", "melon","7"};
	       * 
	       * 1. cherry, apple, banana, melon, 7
	       * 5개의 문자열 중에서 1개가 랜덤하게 출력되게 해 보세요
	       * 
	       * 2. 5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요
	       * 
	    */

		
		Scanner scanner = new Scanner(System.in);
		
		String[] items = {"cherry","apple","banana","melon","7"};
		
		Random random = new Random();
		int ranNum = random.nextInt(items.length);
		
		System.out.println(items[ranNum]);

		String str="";
		
		for(int i=0;i<3;i++) {
			str+=items[random.nextInt(items.length)];
			if(i!=2) str+=" | ";
		}
		
		System.out.println(str);
	}
}
