package demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	/**
	 * 前置通知
	 * @param joinPoint
	 */
	public void checkPri(JoinPoint joinPoint) {
		System.out.println("极限检验========="+joinPoint);
	}
	/**
	 * 后置通知
	 */
	public void writeLog(Object result) {
		System.out.println("日志记录======");
	} 
	/**
	 * 性能监控
	 * @throws Throwable 
	 */
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕前通知======");
		Object obj = joinPoint.proceed();
		System.out.println("环绕后通知======");
		return obj;	
	}
	/**
	 * 异常抛出
	 */
	public void afterThrowing(Throwable ex) {
		System.out.println("异常抛出======"+ex.getMessage());
	}
	/**
	 * 最终通知，相当于finally代码块中的内容
	 */
	public void after() {
		System.out.println("最终通知==========");
	}
}
