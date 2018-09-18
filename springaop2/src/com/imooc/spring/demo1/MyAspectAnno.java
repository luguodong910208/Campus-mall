package com.imooc.spring.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * �����ࣺע���������
 * @author Administrator
 *
 */
@Aspect
public class MyAspectAnno {
	@Before(value="execution(* com.imooc.spring.demo1.OrderDao.save(..))")
	public void before() {
		System.out.println("ǰ����ǿ=======");
	}
	@AfterReturning(value="execution(* com.imooc.spring.demo1.OrderDao.delete(..))",returning="result")
	public void afterReturning(Object result) {
		System.out.println("������ǿ"+result);
	}
	@Around(value="execution(* com.imooc.spring.demo1.OrderDao.update(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("������ǿ=======");
		Object obj = joinPoint.proceed();
		System.out.println("���ƺ���ǿ======");
		return obj;
	}
	@AfterThrowing(value="execution(* com.imooc.spring.demo1.OrderDao.find(..))",throwing="e")
	public void afterThrowing(Throwable e) {
		System.out.println("�쳣�׳���ǿ========"+e.getMessage());
	}
	@After(value="execution(* com.imooc.spring.demo1.OrderDao.find(..))")
	public void after() {
		System.out.println("������ǿ======");
	}
}
