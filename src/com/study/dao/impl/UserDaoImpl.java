package com.study.dao.impl;

import com.study.bean.User;
import com.study.dao.BaseDao;
import com.study.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUsernameAndPassword(User user) {
		// TODO Auto-generated method stub
		String sql = "select * from bs_user where username = ? and password = ?";
		User bean = getBean(sql, user.getUsername(), user.getPassword());
		return bean;
	}

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into bs_user (username, password, email) values (?,?,?)";
		int update = update(sql, user.getUsername(), user.getPassword(), user.getEmail());
		return update > 0;
	}

	@Override
	public boolean checkUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from bs_user where username = ?";
		User user = getBean(sql, username);
		return user != null;
	}

}
