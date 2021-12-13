package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIMain {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("arrange.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:arrange.xml"); //main/resources에 만든 경우
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:pack/arrange.xml"); //main/java/pack에 만든 경우
		
		//singleton 확인 : 스프링은 객체를 한번만 생성하는 것이 default
		MessageImpl aa = (MessageImpl) context.getBean("impl");
		//aa.sayHi();
		System.out.println("aa 객체 주소 : " + aa);
		MessageImpl bb = (MessageImpl) context.getBean("impl");
		//bb.sayHi();
		System.out.println("bb 객체 주소 : " + bb);
		
		
		System.out.println("----------");
		MessageImpl impl = (MessageImpl) context.getBean("impl");
		impl.sayHi();
		
		System.out.println("----다형성------");
		MessageInter inter = (MessageInter) context.getBean("impl");
		inter.sayHi();
		
		System.out.println("----다형성------");
		MessageInter inter2 = (MessageInter) context.getBean("impl",MessageInter.class);
		inter2.sayHi();
	}

}
