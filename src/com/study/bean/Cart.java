package com.study.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable {
	
	//�������еĹ�����
	private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();
	
	//�����������
	private int totalCount;
	
	//��������ܽ��
	private double totalMoney;
	
	/**
	 * ��ȡĳ����Ʒ��Ϣ
	 * @param bookId
	 * @return
	 */
	public CartItem getItem(String bookId) {
		int id = Integer.parseInt(bookId);
		return items.get(id);
	}
	
	/**
	 * ����������
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
	 * �����ܽ��
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
	 * �������й�����
	 * @return
	 */
	public List<CartItem> getAllItems() {
		Collection<CartItem> cartItems = items.values();
		return new ArrayList<>(cartItems);
	}
	
	/**
	 * ��ͼ����ӵ����ﳵ
	 * @param book
	 */
	public void addBookCart(Book book) {
		CartItem cartItem = items.get(book.getId());
		//�жϵ�ǰ�������Ƿ����
		if ( cartItem == null ) {
			//��һ�����
			CartItem item = new CartItem();
			item.setBook(book);
			item.setCount(1);
			
			items.put(book.getId(), item);
		} else {
			//������һ
			cartItem.setCount(cartItem.getCount()+1);
		}
	}
	
	/**
	 * �ӹ��ﳵɾ��ĳһ��
	 * @param bookId
	 */
	public void delete(String bookId) {
		int id = Integer.parseInt(bookId);
		items.remove(id);
	}
	
	/**
	 * �޸�����
	 * @param bookId   Ҫ�޸ĵ���Ŀ
	 * @param count	         Ҫ�޸ĵ�����
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
	 * ���map
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
