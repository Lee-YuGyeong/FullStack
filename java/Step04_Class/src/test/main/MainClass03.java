package test.main;

import test.mypac.Car;

public class MainClass03 {
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		
		car1.brand = "현대";
		car2.brand = "기아";
		car2.brand = "현대";
		
		car1.showBrand();
		car2.showBrand();
		
	}
}
