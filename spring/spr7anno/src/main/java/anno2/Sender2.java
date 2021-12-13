package anno2;

import org.springframework.stereotype.Component;

@Component("s2")
public class Sender2 implements SenderInter{	//다른 클래스에서 호출될 클래스
	public void show() {
		System.out.println("두번째 Sender의 show 메소드 처리하고야 말았군요!");
	}

}
