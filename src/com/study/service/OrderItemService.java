package com.study.service;

import java.util.List;

import com.study.bean.OrderItem;

public interface OrderItemService {
	
	/**
	 * ��ȡ���еĶ�����
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> getOrderItem(String orderId);
	
	/**
	 * ���涩����
	 * @param orderItems
	 */
	public void saveItem(List<OrderItem> orderItems);

}
