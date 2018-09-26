package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	//ע��
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	//ͨ���û�ID��ѯһ���û�
	public User selectUserById(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("mybatis.mapper.UserMapper.findUserById", id);
	}
	//ͨ���û���ģ����ѯ
	public List<User> selectUserByUsername(String name){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("mybatis.mapper.UserMapper.findUserByUsername", name);
	}
}
