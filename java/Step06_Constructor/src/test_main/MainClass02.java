package test_main;

import test.mypac.Car;
import test.mypac.Engine;

public class MainClass02 {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car(new Engine());
		c2.drive();
	}
}
