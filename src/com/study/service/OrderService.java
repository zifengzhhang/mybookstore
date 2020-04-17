package com.study.service;

import java.util.List;

import com.study.bean.Cart;
import com.study.bean.Order;
import com.study.bean.User;

public interface OrderService {
	
	/**
	 * ���˲���
	 * @param cart
	 * @param user
	 */
	public String checkout(Cart cart, User user);
	
	/**
	 * �޸Ķ���״̬
	 * @param orderId
	 * @param status
	 */
	public void updateStatus(String orderId, int status);
	
	/**
	 * ��ȡ���ж���
	 * @return
	 */
	public List<Order> getAllOrder();
	
	/**
	 * ��ȡĳ���û��Ķ���
	 * @param userId
	 * @return
	 */
	public List<Order> getUserByOrder(Integer userId);
}
