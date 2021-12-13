package anno1;

import org.springframework.beans.factory.annotation.Required;

public class Abc {
	private int number;
	
	@Required	//setter 메소드에 반드시 값을 주도록 강요하는 어노테이션(뭔가를 자동으로 실행해주는 메소드로 특정 기능을 실행하도록 정보를 제공)
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void showNumber() {
		System.out.println("number = " + number);
	}
	
}
