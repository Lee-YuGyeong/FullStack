package test.mypac;

//미완성된 추상메소드를 클래스의 멤버로 가질려면 abstract 예약어를 클래스에 명시해야한다.
public abstract class Weapon {
	public void prepare() {
		System.out.println("무기 작동을 준비합니다.");
	}
	//미완성된 추상메소드를 만들때는 abstract 예약어를 메소드에 명시해야한다.
	public abstract void attack();
}
