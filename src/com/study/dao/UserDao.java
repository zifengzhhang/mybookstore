package com.study.dao;

import com.study.bean.User;

public interface UserDao {
	
	/**
	 * �����û��������ѯ�û���Ϣ
	 * @param user
	 * @return
	 */
	public User getUsernameAndPassword(User user);
	
	/**
	 * ע�� �����û�
	 * @param user
	 * @return
	 */
	public boolean saveUser(User user);
	
	/**
	 * ����û����Ƿ����
	 * @param username
	 * @return
	 */
	public boolean checkUsername(String username);

}
