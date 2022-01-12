package org.zerock.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect // 해당 클래스의 객체가 Aspect를 구현한 것임을 나타내기 위해서 사용
@Component //Aop와는 관계가 없지만 스프링에서 빈으로 인식하기위해 사용
public class LogAdvice {

	@Before( "execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		System.out.println("=======================");
	}
	
}
