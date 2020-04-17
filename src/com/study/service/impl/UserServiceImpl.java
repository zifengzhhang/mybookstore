package com.study.service.impl;

import com.study.bean.User;
import com.study.dao.UserDao;
import com.study.dao.impl.UserDaoImpl;
import com.study.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userdao = new UserDaoImpl();
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userdao.getUsernameAndPassword(user);
	}

	@Override
	public boolean regist(User user) {
		// TODO Auto-generated method stub
		return userdao.saveUser(user);
	}

	@Override
	public boolean checkName(String username) {
		// TODO Auto-generated method stub
		return userdao.checkUsername(username);
	}
	
}
