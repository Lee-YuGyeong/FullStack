package test.mypac;

public class Zoo {
	
	//메소드
	public Monkey getMonkey() {
		return new Monkey();
	}
	
	public Tiger getTiger() {
		return new Tiger();
	}
	
	//클래스 안에 클래스 ( 내부 클래스, inner class)
	public class Monkey{
		public void say() {
			System.out.println("안녕 ! 나는 원숭이야");
		}
	}
	public class Tiger{
		public void say() {
			System.out.println("어흥 ! 나는 호랑이야");
		}
	}
}
