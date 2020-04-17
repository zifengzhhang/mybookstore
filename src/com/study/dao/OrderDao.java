package com.study.dao;

import java.util.List;

import com.study.bean.Order;

public interface OrderDao {
	
	/**
	 * ���涩��
	 * @param order
	 */
	public void saveOrder(Order order);
	
	/**
	 * �޸Ķ���״̬
	 * @param order
	 */
	public void updateStatus(Order order);
	
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
	public List<Order> getOrderByUserId(Integer userId);
}
