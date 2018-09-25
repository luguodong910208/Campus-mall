package junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import mybatis.pojo.User;

public class MyBatisDaoTest {
	public SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//¥¥Ω®sqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	@Test
	public void testDao() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.selectUserById(10);
		System.out.println(user);
	}
	@Test
	public void testDao2() {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		List<User> list = userDao.selectUserByUsername("’≈");
		for(User user : list) {
			System.out.println(user);
		}
	}
}
