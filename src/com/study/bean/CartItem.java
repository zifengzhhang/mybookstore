package com.study.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {
	
	//购买的数量
	private int count;
	
	//当前购买的图书
	private Book book;
	
	//总金额
	private double totalPrice;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	/**
	 * 计算当前购物项总金额
	 * @return
	 */
	public double getTotalPrice() {
		BigDecimal totalPrice = new BigDecimal(getBook().getPrice()+"");
		BigDecimal count = new BigDecimal(getCount()+"");
		return totalPrice.multiply(count).doubleValue();
	}

	public CartItem(int count, Book book, double totalPrice) {
		super();
		this.count = count;
		this.book = book;
		this.totalPrice = totalPrice;
	}

	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
