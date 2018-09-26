package junit;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mybatis.mapper.OrderMapper;
import mybatis.mapper.UserMapper;
import mybatis.pojo.Orders;
import mybatis.pojo.QueryVo;
import mybatis.pojo.User;

public class MybatisMapperTest {

	@Test
	public void testMapper() throws Exception {
		//加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactry
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//生成SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession生成实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
	@Test
	public void testMapperQueryVo() throws Exception {
		//加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactry
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//生成SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession生成实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("五");
		vo.setUser(user);
		List<User> users = userMapper.findUserByQueryVo(vo);
		for(User u : users) {
			System.out.println(u);
		}
	}
	@Test
	public void testMapperQueryVoCount() throws Exception {
		//加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactry
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//生成SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession生成实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int count = userMapper.userCount();
		System.out.println(count);
	}
	//根据用户名和性别查询用户
	@Test
	public void testfindUserBySexAndUsername() throws Exception {
		//加载核心配置文件
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactry
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//生成SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession生成实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		user.setUsername("张小明");
		userMapper.selectUserBySexAndUsername(user);
	}
	
//	@Test
//	public void testOrderList() throws Exception {
//		//加载核心配置文件
//		String resource = "SqlMapConfig.xml";
//		InputStream in = Resources.getResourceAsStream(resource);
//		//创建sqlSessionFactory
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//		//生成sqlSession
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//sqlSession生成类
//		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
//		List<Orders> ordersList = mapper.selectOrdersList();
//		for(Orders orders:ordersList) {
//			System.out.println(orders);
//		}
//	}
}
