package test.main;

import test.mypac.DarkTemplar;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MainClass03 {
	
	public static void main(String[] args) {
		
		MyObject obj1 = new MyObject();
		obj1.setInfo("targetStr",new DarkTemplar());
		obj1.useSome(new Radio(), new Speaker());
	}

}
