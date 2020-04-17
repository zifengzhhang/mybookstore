package com.study.dao;

import java.util.List;

import com.study.bean.OrderItem;

public interface OrderItemDao {
	
	/**
	 * 获取某个订单项
	 * @param orderItem
	 * @return
	 */
	public List<OrderItem> getOrderItem(String orderId);
	
	/**
	 * 批量处理sql
	 * @param orderId
	 */
	public void BatchsaveOrderItem(List<OrderItem> orderItems);
}
