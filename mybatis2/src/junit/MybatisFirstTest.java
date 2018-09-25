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
	//�����û�ID��ѯһ���û�
	@Test
	public void testMybatis() throws Exception{
		//���غ��������ļ�
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��sql���
		User user = sqlSession.selectOne("test.findUserById",10);
		System.out.println(user);
	}
	//�����û���ʵ��ģ����ѯ
	@Test
	public void testFindUserByUsername() throws Exception{
		//���غ��������ļ�
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��sql���
		List<User> users = sqlSession.selectList("test.findUserByUsername","��");
		for(User user:users) {
			System.out.println(user);
		}
	}
	//����û�
	@Test
	public void testInsertUser() throws Exception{
		//���غ��������ļ�
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��sql���
		User user = new User();
		user.setUsername("xiaoda");
		user.setAddress("shenzhen");
		user.setBirthday(new Date());
		user.setSex("��");
		int i = sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		System.out.println(user.getId());
	}
	//�����û�
	@Test
	public void testUpdateUserById() throws Exception{
		//���غ��������ļ�
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��sql���
		User user = new User();
		user.setId(31);
		user.setUsername("xiaolaohu");
		user.setAddress("hunan");
		user.setBirthday(new Date());
		user.setSex("Ů");
		int i = sqlSession.update("test.updateUserById", user);
		sqlSession.commit();
		System.out.println(user.getId());
	}
	//�����û�
	@Test
	public void testDeleteUserById() throws Exception{
		//���غ��������ļ�
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��sql���
		sqlSession.delete("test.deleteUserById", 32);
		sqlSession.commit();
	}
}
