package com.imooc.spring.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * �����ࣺע���������
 * @author Administrator
 *
 */
@Aspect
public class MyAspectAnno2 {
	@Before(value="MyAspectAnno2.pointcut1()")
	public void before() {
		System.out.println("ǰ����ǿ=======");
	}
	@AfterReturning(value="MyAspectAnno2.pointcut2()",returning="result")
	public void afterReturning(Object result) {
		System.out.println("������ǿ"+result);
	}
	@Around(value="MyAspectAnno2.pointcut3()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("������ǿ=======");
		Object obj = joinPoint.proceed();
		System.out.println("���ƺ���ǿ======");
		return obj;
	}
	@AfterThrowing(value="MyAspectAnno2.pointcut4()",throwing="e")
	public void afterThrowing(Throwable e) {
		System.out.println("�쳣�׳���ǿ========"+e.getMessage());
	}
	@After(value="MyAspectAnno2.pointcut4()")
	public void after() {
		System.out.println("������ǿ======");
	}
	//�����ע��
	@Pointcut(value="execution(* com.imooc.spring.demo1.OrderDao.save(..))")
	private void pointcut1() {}
	@Pointcut(value="execution(* com.imooc.spring.demo1.OrderDao.delete(..))")
	private void pointcut2() {}
	@Pointcut(value="execution(* com.imooc.spring.demo1.OrderDao.update(..))")
	private void pointcut3() {}
	@Pointcut(value="execution(* com.imooc.spring.demo1.OrderDao.find(..))")
	private void pointcut4() {}
}
