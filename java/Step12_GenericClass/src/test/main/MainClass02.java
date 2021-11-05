package test.main;

import java.util.List;

import test.mypac.Apple;
import test.mypac.Banana;
import test.mypac.FruitBox;
import test.mypac.Orange;

//ctrl + shift + o => 일괄 import 단축키

public class MainClass02 {
	public static void main(String[] args) {
		//객체를 생성할때 Generic 클래스는 생략이 가능하다.
		FruitBox<Apple> box1 = new FruitBox<>();
		FruitBox<Orange> box2 = new FruitBox<>();
		FruitBox<Banana> box3 = new FruitBox<>();
		
		List<Apple> list = null;
		list.add();
	}
}
