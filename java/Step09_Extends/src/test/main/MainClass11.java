package test.main;

import test.auto.Engine;
import test.auto.Hcar;

/*
 * 1. Car 클래스를 상속받는 클래스를 test.auto 패키지에 아무거나 정의해서 만들어보세요.
 * 2. 만든 클래스를 이용해서 객체생성후 메소드를 호출하는 코드를 main() 메소드 안에 작성해보세요.
 * 3. 테스트 후 만든 클래스의 내용과 main()메소드에 작성한 내용을 보내주세요.
 */
public class MainClass11 {
	public static void main(String[] args) {
		Hcar car1 = new Hcar(new Engine());
		
		car1.sample();
	}
}
