package com.imooc.store.service;

import java.sql.SQLException;

import com.imooc.store.domain.User;

public interface UserService {

	void userRegist(User user) throws SQLException;
	
	boolean userActive(String code) throws SQLException;
	
	User userLogin(User user) throws SQLException;
}
