package com.imooc.store.service.serviceImp;

import java.sql.SQLException;

import com.imooc.store.dao.UserDao;
import com.imooc.store.dao.daoImp.UserDaoImp;
import com.imooc.store.domain.User;
import com.imooc.store.service.UserService;

public class UserServiceImp implements UserService {

	@Override
	public void userRegist(User user) throws SQLException {
		//×¢²á¹¦ÄÜ
		UserDao userDao = new UserDaoImp();
		userDao.userRegist(user);
	}

}
