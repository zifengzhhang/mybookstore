package com.study.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.study.bean.Book;
import com.study.bean.Cart;
import com.study.bean.CartItem;
import com.study.bean.Order;
import com.study.bean.OrderItem;
import com.study.bean.User;
import com.study.dao.OrderDao;
import com.study.dao.impl.OrderDaoImpl;
import com.study.service.BookService;
import com.study.service.OrderItemService;
import com.study.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao od = new OrderDaoImpl();
	private OrderItemService oItemservice = new OrderItemServiceImpl();
	private BookService bs = new BookServiceImpl();
	
	@Override
	public String checkout(Cart cart, User user) {
		// TODO Auto-generated method stub
		//结账操作，把购物车里的数据封装成订单保存
		//生成订单号
		long millis = System.currentTimeMillis();
		String orderId = millis+""+user.getId();
		
		Order order = new Order();
		//封装订单对象
		order.setOrderId(orderId);
		order.setCreateDate(new Date());
		order.setTotalMoney(cart.getTotalMoney());
		order.setStatus(0);
		order.setUserId(user.getId());
		
		//封装订单项对象
		List<CartItem> allItems = cart.getAllItems();
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for ( CartItem item : allItems ) {
			OrderItem orderItem = new OrderItem(item.getBook().getId(), item.getBook().getTitle(),  
					item.getCount(), item.getBook().getPrice(),
					item.getTotalPrice(), order.getOrderId());
			orderItems.add(orderItem);
		}
		
		//保存订单和订单项
		od.saveOrder(order);
		oItemservice.saveItem(orderItems);
		
		//修改图书相应的库存和销量
		for ( CartItem item : allItems ) {
			Book book = item.getBook();
			Book alterbook = bs.getBook(book.getId()+"");
			
			int count = item.getCount();
			alterbook.setSales(alterbook.getSales()+count);
			alterbook.setStock(alterbook.getStock()-count);
			
			//更新图书信息
			bs.update(alterbook);
		}
		
		//结账完成清除购物车
		cart.clear();
		//返回订单号
		return orderId;
	}

	@Override
	public void updateStatus(String orderId, int status) {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setOrderId(orderId);
		order.setStatus(status);
		
		//修改订单状态
		od.updateStatus(order);
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return od.getAllOrder();
	}

	@Override
	public List<Order> getUserByOrder(Integer userId) {
		// TODO Auto-generated method stub
		return od.getOrderByUserId(userId);
	}

}
