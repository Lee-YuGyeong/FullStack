package test.main;

import test.mypac.DarkTemplar;
import test.mypac.MyObject;

public class MainClass01 {
	public static void main(String[] args) {
		MyObject obj = new MyObject();
		obj.walk();
		
		int num = obj.getNumber();
		String greet = obj.getGreeting();
		DarkTemplar dark1 = obj.getTemplar();
		
		obj.setNum(999);
		obj.setName("김구라");
		
	}
}
