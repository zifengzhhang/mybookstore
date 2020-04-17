package com.study.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable {
	
	//保存所有的购物项
	private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();
	
	//代表购买的总数
	private int totalCount;
	
	//所有项的总金额
	private double totalMoney;
	
	/**
	 * 获取某个物品信息
	 * @param bookId
	 * @return
	 */
	public CartItem getItem(String bookId) {
		int id = Integer.parseInt(bookId);
		return items.get(id);
	}
	
	/**
	 * 计算总数量
	 * @return
	 */
	public int getTotalCount() {
		List<CartItem> allItems = getAllItems();
		int count = 0;
		for ( CartItem item : allItems ) {
			count += item.getCount();
		}
		
		return count;
	}
	
	/**
	 * 计算总金额
	 * @return
	 */
	public double getTotalMoney() {
		List<CartItem> allItems = getAllItems();
		BigDecimal totalPrice = new BigDecimal(0.0+"");
		for ( CartItem item : allItems ) {
			BigDecimal amount = new BigDecimal(item.getTotalPrice()+"");
			totalPrice = totalPrice.add(amount);
		}
		
		return totalPrice.doubleValue();
	}
	
	/**
	 * 返回所有购物项
	 * @return
	 */
	public List<CartItem> getAllItems() {
		Collection<CartItem> cartItems = items.values();
		return new ArrayList<>(cartItems);
	}
	
	/**
	 * 把图书添加到购物车
	 * @param book
	 */
	public void addBookCart(Book book) {
		CartItem cartItem = items.get(book.getId());
		//判断当前购物项是否存在
		if ( cartItem == null ) {
			//第一次添加
			CartItem item = new CartItem();
			item.setBook(book);
			item.setCount(1);
			
			items.put(book.getId(), item);
		} else {
			//数量加一
			cartItem.setCount(cartItem.getCount()+1);
		}
	}
	
	/**
	 * 从购物车删除某一项
	 * @param bookId
	 */
	public void delete(String bookId) {
		int id = Integer.parseInt(bookId);
		items.remove(id);
	}
	
	/**
	 * 修改数量
	 * @param bookId   要修改的条目
	 * @param count	         要修改的数量
	 */
	public void updateCount(String bookId, String count) {
		int id = 0;
		int amount = 1;
		try {
			id = Integer.parseInt(bookId);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			amount = Integer.parseInt(count);
			amount = amount>0?amount:1;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CartItem cartItem = items.get(id);
		if ( cartItem != null )
			cartItem.setCount(amount);
	}
	
	/**
	 * 清空map
	 */
	public void clear() {
		items.clear();
	}
	
	public Cart(Map<Integer, CartItem> items, int totalCount, double totalMoney) {
		super();
		this.items = items;
		this.totalCount = totalCount;
		this.totalMoney = totalMoney;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
