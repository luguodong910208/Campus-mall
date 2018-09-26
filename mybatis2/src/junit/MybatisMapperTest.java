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
		//���غ��������ļ�
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactry
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession����ʵ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(10);
		System.out.println(user);
	}
	@Test
	public void testMapperQueryVo() throws Exception {
		//���غ��������ļ�
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactry
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession����ʵ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("��");
		vo.setUser(user);
		List<User> users = userMapper.findUserByQueryVo(vo);
		for(User u : users) {
			System.out.println(u);
		}
	}
	@Test
	public void testMapperQueryVoCount() throws Exception {
		//���غ��������ļ�
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactry
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession����ʵ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int count = userMapper.userCount();
		System.out.println(count);
	}
	//�����û������Ա��ѯ�û�
	@Test
	public void testfindUserBySexAndUsername() throws Exception {
		//���غ��������ļ�
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactry
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//SqlSession����ʵ����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		user.setUsername("��С��");
		userMapper.selectUserBySexAndUsername(user);
	}
	
//	@Test
//	public void testOrderList() throws Exception {
//		//���غ��������ļ�
//		String resource = "SqlMapConfig.xml";
//		InputStream in = Resources.getResourceAsStream(resource);
//		//����sqlSessionFactory
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//		//����sqlSession
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//sqlSession������
//		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
//		List<Orders> ordersList = mapper.selectOrdersList();
//		for(Orders orders:ordersList) {
//			System.out.println(orders);
//		}
//	}
}
