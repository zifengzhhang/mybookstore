package com.study.dao;

import java.util.List;

import com.study.bean.OrderItem;

public interface OrderItemDao {
	
	/**
	 * ��ȡĳ��������
	 * @param orderItem
	 * @return
	 */
	public List<OrderItem> getOrderItem(String orderId);
	
	/**
	 * ��������sql
	 * @param orderId
	 */
	public void BatchsaveOrderItem(List<OrderItem> orderItems);
}
