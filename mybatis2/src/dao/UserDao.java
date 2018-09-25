package dao;

import java.util.List;

import mybatis.pojo.User;

public interface UserDao {
	//通过用户ID查询一个用户
	User selectUserById(Integer id);
	//通过用户名模糊查询
	List<User> selectUserByUsername(String name);
}
