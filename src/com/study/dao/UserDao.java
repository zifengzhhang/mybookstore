package com.study.dao;

import com.study.bean.User;

public interface UserDao {
	
	/**
	 * 根据用户名密码查询用户信息
	 * @param user
	 * @return
	 */
	public User getUsernameAndPassword(User user);
	
	/**
	 * 注册 保存用户
	 * @param user
	 * @return
	 */
	public boolean saveUser(User user);
	
	/**
	 * 检查用户名是否存在
	 * @param username
	 * @return
	 */
	public boolean checkUsername(String username);

}
