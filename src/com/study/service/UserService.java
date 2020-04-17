package com.study.service;

import com.study.bean.User;

public interface UserService {
	
	/**
	 * ÓÃ»§µÇÂ¼×¢²á
	 * @param user
	 * @return
	 */
	
	public User login(User user);
	
	public boolean regist(User user);
	
	public boolean checkName(String username);

}
