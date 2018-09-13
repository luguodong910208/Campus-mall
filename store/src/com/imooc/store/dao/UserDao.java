package com.imooc.store.dao;

import java.sql.SQLException;

import com.imooc.store.domain.User;

public interface UserDao {

	void userRegist(User user) throws SQLException;

}
