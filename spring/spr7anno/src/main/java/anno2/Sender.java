package anno2;

import org.springframework.stereotype.Component;

//@Component
//@Component("sender")
@Component("s1")
public class Sender implements SenderInter{	//다른 클래스에서 호출될 클래스
	public void show() {
		System.out.println("첫번째 Sender의 show 메소드 수행~~~");
	}

}
