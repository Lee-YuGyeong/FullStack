package anno1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("anno1.xml");
		Abc abc = context.getBean("abc",Abc.class);
		abc.showNumber();
		
	}

}
