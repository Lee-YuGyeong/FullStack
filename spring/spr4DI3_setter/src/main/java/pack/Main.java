package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		/*
		MyProcess myProcess = new MyProcess();
		myProcess.setName("홍길동");
		myProcess.setNai(23);
		myProcess.displayData();
		*/
		
		System.out.println("-----------------");
		ApplicationContext context = new ClassPathXmlApplicationContext("sijak.xml");
		//MyProcess myProcess2 = (MyProcess)context.getBean("myProcess");
		MyProcess myProcess2 = context.getBean("myProcess",MyProcess.class); //위와 동일
		myProcess2.displayData();
		
	}
}
