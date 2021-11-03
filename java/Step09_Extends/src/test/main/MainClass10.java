package test.main;

import test.auto.Ecar;
import test.auto.Engine;

public class MainClass10 {
	public static void main(String[] args) {
		//Ecar 객체를 생성해서 .drive(), .autoPilot() 메소드를 호출해보세요
		Ecar car1 = new Ecar(new Engine());
		car1.drive();
		car1.autoPilot();
	}
}
