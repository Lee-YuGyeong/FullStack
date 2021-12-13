package anno2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Anno2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("anno2.xml");
		//SenderProcess senderProcess = (SenderProcess)context.getBean("sprocess");
		SenderProcess senderProcess = (SenderProcess)context.getBean("senderProcess");
		senderProcess.displayData();

	}
	

}
