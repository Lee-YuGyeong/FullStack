package anno2_1;

import org.springframework.stereotype.Component;

@Component
public class Test {
	public void abc() {
		System.out.println("다른 패키지에 있는 클래스의 메소드를 호출");
	}
	
}
