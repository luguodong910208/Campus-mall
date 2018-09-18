package demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	/**
	 * ǰ��֪ͨ
	 * @param joinPoint
	 */
	public void checkPri(JoinPoint joinPoint) {
		System.out.println("���޼���========="+joinPoint);
	}
	/**
	 * ����֪ͨ
	 */
	public void writeLog(Object result) {
		System.out.println("��־��¼======");
	} 
	/**
	 * ���ܼ��
	 * @throws Throwable 
	 */
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("����ǰ֪ͨ======");
		Object obj = joinPoint.proceed();
		System.out.println("���ƺ�֪ͨ======");
		return obj;	
	}
	/**
	 * �쳣�׳�
	 */
	public void afterThrowing(Throwable ex) {
		System.out.println("�쳣�׳�======"+ex.getMessage());
	}
	/**
	 * ����֪ͨ���൱��finally������е�����
	 */
	public void after() {
		System.out.println("����֪ͨ==========");
	}
}
