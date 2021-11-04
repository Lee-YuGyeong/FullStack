package test.main;

import test.mypac.Gun;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * 여러분이 직접 Weapon 추상 클래스를 상속받아서 클래스를 정의하고
		 * 해당 클래스를 활용해서 
		 * 아래의 useWeapon() 메소드를 호출해보세요.
		 */
		Weapon w = new Gun();
		MainClass02.useWeapon(w);
	}
	//Weapon 추상클래스 type을 메소드의 인자로 전달받는 static 메소드
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		w.attack();
	}
}
