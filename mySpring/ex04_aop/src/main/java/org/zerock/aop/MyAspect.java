package org.zerock.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object target = null;
		System.out.println("�⼮�Ѵ�.");
		try {
			target = invocation.proceed();
		} catch (Exception e) {
			System.out.println("���³��̾���.");
		} finally {
			System.out.println("��������.");
		}
		return target;
	}
}
