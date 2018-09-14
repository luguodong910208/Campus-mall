package com.imooc.store.service.serviceImp;

import java.sql.SQLException;

import com.imooc.store.dao.UserDao;
import com.imooc.store.dao.daoImp.UserDaoImp;
import com.imooc.store.domain.User;
import com.imooc.store.service.UserService;

public class UserServiceImp implements UserService {

	@Override
	public void userRegist(User user) throws SQLException {
		//ע�Ṧ��
		UserDao userDao = new UserDaoImp();
		userDao.userRegist(user);
	}

	@Override
	public boolean userActive(String code) throws SQLException {
		//ʵ�ּ����
		UserDao userDao = new UserDaoImp();
		//��DB����select * from user where code = ?
		User user = userDao.useraActive(code);
		if(null != user) {
			//���Ը��ݼ������ѯ�û�
			//�޸��û���״̬�����״̬��
			user.setState(1);
			user.setCode(null);
			//�����ݿ����һ����ʵ�ĸ��²���
			userDao.updateUser(user);
			return true;
		}else {
			//�����Ը��ݼ������ѯ���û�
			return false;
		}
	}

	@Override
	public User userLogin(User user) throws SQLException {
		UserDao userDao = new UserDaoImp();
		User uu = userDao.userLogin(user);
		//ʹ���쳣��ģ��֮�䴫������
		if(null == uu) {
			throw new RuntimeException("��������");
		}else if(uu.getState() == 0) {
			throw new RuntimeException("�û�δ����!");
		}else {
			return uu;
		}
	}

}
