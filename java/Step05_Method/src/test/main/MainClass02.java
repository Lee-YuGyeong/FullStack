package test.main;

import test.mypac.DarkTemplar;
import test.mypac.MyObject;

public class MainClass02 {
	public static void main(String[] args) {
		MyObject obj = new MyObject();
		//obj 객체의 .setTemplar() 메소드를 호출해보세요.
		obj.setTemplar(new DarkTemplar());
		
		DarkTemplar t1 = new DarkTemplar();
		obj.setTemplar(t1);

		obj.setData(10,"hello");
		
		
	}

}
