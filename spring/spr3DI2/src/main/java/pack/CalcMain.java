package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("init3.xml");
		
		MyInter myInter = (MyInter) context.getBean("myProcess");
		myInter.inputMoney();
		myInter.showResult();

	}

}
