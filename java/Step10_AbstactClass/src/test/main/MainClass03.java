package test.main;

import test.mypac.Zoo;
import test.mypac.Zoo.Monkey;

public class MainClass03 {
	public static void main(String[] args) {
		Zoo z = new Zoo();
		
		//inner class type Monkey
		Monkey m1 = z.getMonkey();
		m1.say();
	}
}
