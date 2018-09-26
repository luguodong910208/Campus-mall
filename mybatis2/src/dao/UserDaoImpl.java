package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.pojo.User;

public class UserDaoImpl implements UserDao {
	//注入
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	//通过用户ID查询一个用户
	public User selectUserById(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("mybatis.mapper.UserMapper.findUserById", id);
	}
	//通过用户名模糊查询
	public List<User> selectUserByUsername(String name){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("mybatis.mapper.UserMapper.findUserByUsername", name);
	}
}
