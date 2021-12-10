package pack.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pack.DataDao;
import pack.DataDaoImpl;

public class Main {
	public static void main(String[] args) {
		//순수 자바로 처리
		//DB 처리용
		DataDaoImpl daoImpl = new DataDaoImpl();
		DataDao dataDao = daoImpl;
		
		//비즈니스 로직용
		SelectServiceImpl serviceImpl = new SelectServiceImpl(dataDao);
		SelectService selectService = serviceImpl;
		selectService.selectProcess();
		
		System.out.println("-- 스프링 컨테이너 기능 사용 --------");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("init2.xml");
		SelectService selectService2 = (SelectService) context.getBean("ssimpl");
		selectService2.selectProcess();
		
		
	}
}
