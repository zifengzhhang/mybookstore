package com.study.bean;

public class OrderItem {
	
	//ͼ��id
	private Integer id;
	
	//ͼ������
	private String title;
	
	//ͼ�������
	private int count;
	
	//ͼ��ļ۸�
	private double price;
	
	//��ǰͼ���ܽ��
	private double totalPrice;
	
	//��ǰͼ�������Ķ�����
	private String orderId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public OrderItem(Integer id, String title, int count, double price, double totalPrice, String orderId) {
		super();
		this.id = id;
		this.title = title;
		this.count = count;
		this.price = price;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
