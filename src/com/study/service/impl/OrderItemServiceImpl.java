package com.study.service.impl;

import java.util.List;

import com.study.bean.OrderItem;
import com.study.dao.OrderItemDao;
import com.study.dao.impl.OrderItemDaoImpl;
import com.study.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
	
	private OrderItemDao oItemdao = new OrderItemDaoImpl();

	@Override
	public List<OrderItem> getOrderItem(String orderId) {
		// TODO Auto-generated method stub
		return oItemdao.getOrderItem(orderId);
	}

	@Override
	public void saveItem(List<OrderItem> orderItems) {
		// TODO Auto-generated method stub
		oItemdao.BatchsaveOrderItem(orderItems);
	}

}
