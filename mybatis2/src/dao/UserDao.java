package dao;

import java.util.List;

import mybatis.pojo.User;

public interface UserDao {
	//ͨ���û�ID��ѯһ���û�
	User selectUserById(Integer id);
	//ͨ���û���ģ����ѯ
	List<User> selectUserByUsername(String name);
}
