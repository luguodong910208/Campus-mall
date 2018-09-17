package springdemo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {
/**
	@Test
	//传统测试方法
	public void demo1() {
		UserDaoImpl userDao = new UserDaoImpl();
		//userDao.setName("winston");
		userDao.save();
	}
	
	@Test
	//Spring的IOC注解方式
	public void demo2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.save();
	}
**/	
	@Test
	//Spring的IOC注解方式
	public void demo3() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.save();
	}
}
