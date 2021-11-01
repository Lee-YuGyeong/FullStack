package test.main;

import test.mypac.Gun;

public class MainClass05 {
	public static void main(String[] args) {
		//객체를 생성해서 동일한 메소드를 여러번 호출하기
		Gun g = new Gun();
		g.fire();
		g.fire();
		g.fire();
		//메소드 안에서 this를 리턴하는 메소드의 사용
		new Gun().fire().fire().fire();
	}
}
