package com.study.service;

import java.util.List;

import com.study.bean.OrderItem;

public interface OrderItemService {
	
	/**
	 * 获取所有的订单项
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> getOrderItem(String orderId);
	
	/**
	 * 保存订单项
	 * @param orderItems
	 */
	public void saveItem(List<OrderItem> orderItems);

}
