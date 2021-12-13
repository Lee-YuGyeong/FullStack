package anno2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import anno2_1.Test;


//@Component("sprocess")
//@Component("senderProcess")	//아래와 같은 의미
@Component
@ComponentScan("anno2_1")		//다른 패키지에 있는 클래스의 어노테이션을 스캔
public class SenderProcess {
	//@Autowired				//내부적으로 setter를 만들고 setter injection을 수행. type에 의한 매핑
	//private Sender sender;	//현재 프로젝트에서 객체변수와는 상관없이 어디선가 만들어진 Sender 객체의 주소를 치환 
	
	@Autowired
	//@Qualifier("s1") 			//@Autowired와 함께하는 어노테이션으로 이름에 의한 매핑이 가능해짐.
	@Qualifier("s2")	
	private SenderInter inter;	//type에 의한 매핑으로 SenderInter의 자식 클래스 객체의 주소를 치환
	
	/*
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	*/
	
	@Autowired
	private Test test;
	
	public void displayData() {
		System.out.println("displayData 메소드 처리");
		//sender.show();
		inter.show();
		
		test.abc();
	}
}
