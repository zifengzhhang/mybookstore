package com.study.service;

import java.util.List;

import com.study.bean.Cart;
import com.study.bean.Order;
import com.study.bean.User;

public interface OrderService {
	
	/**
	 * 结账操作
	 * @param cart
	 * @param user
	 */
	public String checkout(Cart cart, User user);
	
	/**
	 * 修改订单状态
	 * @param orderId
	 * @param status
	 */
	public void updateStatus(String orderId, int status);
	
	/**
	 * 获取所有订单
	 * @return
	 */
	public List<Order> getAllOrder();
	
	/**
	 * 获取某个用户的订单
	 * @param userId
	 * @return
	 */
	public List<Order> getUserByOrder(Integer userId);
}
