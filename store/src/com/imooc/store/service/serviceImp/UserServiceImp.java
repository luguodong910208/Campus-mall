package com.imooc.store.service.serviceImp;

import java.sql.SQLException;

import com.imooc.store.dao.UserDao;
import com.imooc.store.dao.daoImp.UserDaoImp;
import com.imooc.store.domain.User;
import com.imooc.store.service.UserService;

public class UserServiceImp implements UserService {

	@Override
	public void userRegist(User user) throws SQLException {
		//注册功能
		UserDao userDao = new UserDaoImp();
		userDao.userRegist(user);
	}

	@Override
	public boolean userActive(String code) throws SQLException {
		//实现激活功能
		UserDao userDao = new UserDaoImp();
		//对DB发送select * from user where code = ?
		User user = userDao.useraActive(code);
		if(null != user) {
			//可以根据激活码查询用户
			//修改用户的状态，清楚状态码
			user.setState(1);
			user.setCode(null);
			//对数据库进行一次真实的更新操作
			userDao.updateUser(user);
			return true;
		}else {
			//不可以根据激活码查询到用户
			return false;
		}
	}

	@Override
	public User userLogin(User user) throws SQLException {
		UserDao userDao = new UserDaoImp();
		User uu = userDao.userLogin(user);
		//使用异常在模块之间传递数据
		if(null == uu) {
			throw new RuntimeException("密码有误！");
		}else if(uu.getState() == 0) {
			throw new RuntimeException("用户未激活!");
		}else {
			return uu;
		}
	}

}
