package springdemo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {
/**
	@Test
	//��ͳ���Է���
	public void demo1() {
		UserDaoImpl userDao = new UserDaoImpl();
		//userDao.setName("winston");
		userDao.save();
	}
	
	@Test
	//Spring��IOCע�ⷽʽ
	public void demo2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.save();
	}
**/	
	@Test
	//Spring��IOCע�ⷽʽ
	public void demo3() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.save();
	}
}
