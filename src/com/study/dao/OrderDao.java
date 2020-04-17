package com.study.dao;

import java.util.List;

import com.study.bean.Order;

public interface OrderDao {
	
	/**
	 * 保存订单
	 * @param order
	 */
	public void saveOrder(Order order);
	
	/**
	 * 修改订单状态
	 * @param order
	 */
	public void updateStatus(Order order);
	
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
	public List<Order> getOrderByUserId(Integer userId);
}
