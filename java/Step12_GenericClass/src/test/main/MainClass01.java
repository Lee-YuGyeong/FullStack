package test.main;

import test.mypac.Apple;
import test.mypac.FruitBox;
import test.mypac.Orange;
import test.mypac.box;

public class MainClass01 {
	public static void main(String[] args) {
		FruitBox<Apple> box1 = new FruitBox<Apple>();
		box1.push(new Apple());
		
		//Orange 객체를 담을 FruitBox 객체를 생성해서 참조값을 box2라는 지역변수에 담아 보세요.
		FruitBox<Orange> box2 = new FruitBox<Orange>();
		//box2에 Orange 객체를 담아보세요.
		box2.push(new Orange());
		
		//Generic 클래스로 지정한 type 객체가 리턴된다.
		Apple item1 = box1.pull();
		Orange item2 = box2.pull();
		
		
	}
}
