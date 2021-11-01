package test_main;

import test.mypac.Car;
import test.mypac.Engine;

public class MainClass01 {
	public static void main(String[] args) {
		
		Car c1 = new Car();
		c1.engine = new Engine();
		c1.drive();
	}
}
