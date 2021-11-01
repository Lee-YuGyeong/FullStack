package test.main;

import test.mypac.Messenger;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MainClass04 {
	public static void main(String[] args) {
		MyObject obj = new MyObject();
		obj.useSome(new Radio(), new Speaker());
		
		
		//다중 정의된 메소드 사용해 보기
		Messenger m = new Messenger();
		m.sendMessage();
		m.sendMessage("hi");
		m.sendMessage(999);
		
	}


}
