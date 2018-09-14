package com.imooc.store.dao;

import java.sql.SQLException;

import com.imooc.store.domain.User;

public interface UserDao {

	void userRegist(User user) throws SQLException;

	User useraActive(String code) throws SQLException;

	void updateUser(User user) throws SQLException;

	User userLogin(User user) throws SQLException;

}
