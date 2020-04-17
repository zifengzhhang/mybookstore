package com.study.dao.impl;

import java.util.List;

import com.study.bean.Order;
import com.study.dao.BaseDao;
import com.study.dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		String sql = "insert into bs_order (order_id, create_date, total_money, status, user_id) values "
				+ "(?,?,?,?,?)";
		update(sql, order.getOrderId(), order.getCreateDate(), order.getTotalMoney(), 
				order.getStatus(), order.getUserId());
	}

	@Override
	public void updateStatus(Order order) {
		// TODO Auto-generated method stub
		String sql = "update bs_order set status = ? where order_id = ?";
		update(sql, order.getStatus(), order.getOrderId());
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		String sql = "select order_id orderId, create_date createDate, total_money totalMoney, "
				+ "status, user_id userId from bs_order";
		return getBeanList(sql);
	}

	@Override
	public List<Order> getOrderByUserId(Integer userId) {
		// TODO Auto-generated method stub
		String sql = "select order_id orderId, create_date createDate, total_money totalMoney, "
				+ "status, user_id userId from bs_order where user_id = ?";
		return getBeanList(sql, userId);
	}

}
