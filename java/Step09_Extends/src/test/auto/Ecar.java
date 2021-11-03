package test.auto;

public class Ecar extends Car{

	//자식 생성자에서 부모 생성자에 필요한 값을 받아서
	public Ecar(Engine engine) {
		//부모 생성자를 호출하면서 전달해야한다.
		super(engine); 
	}
	
	//기능(Method)
	public void autoPilot() {
		System.out.println("자율 주행을 해요");
		
	}
}
