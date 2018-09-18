package com.imooc.spring.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 切面类：注解的切面类
 * @author Administrator
 *
 */
@Aspect
public class MyAspectAnno {
	@Before(value="execution(* com.imooc.spring.demo1.OrderDao.save(..))")
	public void before() {
		System.out.println("前置增强=======");
	}
	@AfterReturning(value="execution(* com.imooc.spring.demo1.OrderDao.delete(..))",returning="result")
	public void afterReturning(Object result) {
		System.out.println("后置增强"+result);
	}
	@Around(value="execution(* com.imooc.spring.demo1.OrderDao.update(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕增强=======");
		Object obj = joinPoint.proceed();
		System.out.println("环绕后增强======");
		return obj;
	}
	@AfterThrowing(value="execution(* com.imooc.spring.demo1.OrderDao.find(..))",throwing="e")
	public void afterThrowing(Throwable e) {
		System.out.println("异常抛出增强========"+e.getMessage());
	}
	@After(value="execution(* com.imooc.spring.demo1.OrderDao.find(..))")
	public void after() {
		System.out.println("最终增强======");
	}
}
