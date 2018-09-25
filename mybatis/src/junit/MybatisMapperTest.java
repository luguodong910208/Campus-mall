package junit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mybatis.mapper.UserMapper;
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
}
