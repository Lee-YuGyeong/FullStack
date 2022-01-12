package org.zerock.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect // �ش� Ŭ������ ��ü�� Aspect�� ������ ������ ��Ÿ���� ���ؼ� ���
@Component //Aop�ʹ� ���谡 ������ ���������� ������ �ν��ϱ����� ���
public class LogAdvice {

	@Before( "execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		System.out.println("=======================");
	}
	
}
