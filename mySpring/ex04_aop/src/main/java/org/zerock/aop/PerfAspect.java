package org.zerock.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

	@Around("execution(* com.saelobi..*.EventService.*(..))")
	public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
		long begin = System.currentTimeMillis();
		Object retVal = pjp.proceed(); // �޼��� ȣ�� ��ü�� ����
		System.out.println(System.currentTimeMillis() - begin);
		return retVal;
	}
}