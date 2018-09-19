package junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mybatis.pojo.User;

public class MybatisFirstTest {
	//根据用户ID查询一个用户
	@Test
	public void testMybatis() throws Exception{
		//加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = sqlSession.selectOne("test.findUserById",10);
		System.out.println(user);
	}
	//根据用户名实现模糊查询
	@Test
	public void testFindUserByUsername() throws Exception{
		//加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		List<User> users = sqlSession.selectList("test.findUserByUsername","张");
		for(User user:users) {
			System.out.println(user);
		}
	}
	//添加用户
	@Test
	public void testInsertUser() throws Exception{
		//加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = new User();
		user.setUsername("xiaoda");
		user.setAddress("shenzhen");
		user.setBirthday(new Date());
		user.setSex("男");
		int i = sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		System.out.println(user.getId());
	}
	//更新用户
	@Test
	public void testUpdateUserById() throws Exception{
		//加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = new User();
		user.setId(31);
		user.setUsername("xiaolaohu");
		user.setAddress("hunan");
		user.setBirthday(new Date());
		user.setSex("女");
		int i = sqlSession.update("test.updateUserById", user);
		sqlSession.commit();
		System.out.println(user.getId());
	}
	//更新用户
	@Test
	public void testDeleteUserById() throws Exception{
		//加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		sqlSession.delete("test.deleteUserById", 32);
		sqlSession.commit();
	}
}
