package com.study.dao.impl;

import java.util.List;

import com.study.bean.OrderItem;
import com.study.dao.BaseDao;
import com.study.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

	@Override
	public List<OrderItem> getOrderItem(String orderId) {
		// TODO Auto-generated method stub
		String sql = "select id, title, count, price, total_price totalPrice, "
				+ "order_id orderId from bs_order_item where order_id = ?";
		return getBeanList(sql, orderId);
	}
	
	/**
	 * 批量处理sql
	 */
	@Override
	public void BatchsaveOrderItem(List<OrderItem> orderItems) {
		// TODO Auto-generated method stub
		String sql = "insert into bs_order_item (title, count, price, total_price, order_id) "
				+ "values (?,?,?,?,?)";
		Object[][] objs = new Object[orderItems.size()][5];
		int count = 0;
		
		for ( OrderItem item : orderItems ) {
			objs[count++] = new Object[] {
				item.getTitle(), item.getCount(), item.getPrice(),
				item.getTotalPrice(), item.getOrderId()
			};
		}
		
		Batchsave(sql, objs);
	}
	
}
