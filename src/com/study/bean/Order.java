package com.study.bean;

import java.util.Date;

public class Order {
	
	//�û��Ķ�����
	private String orderId;
	
	//�����Ĵ�������
	private Date createDate;
	
	//�����ܽ��
	private double totalMoney;
	
	//������״̬
	private int status;
	
	//�������������û�id
	private Integer userId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Order(String orderId, Date createDate, double totalMoney, int status, Integer userId) {
		super();
		this.orderId = orderId;
		this.createDate = createDate;
		this.totalMoney = totalMoney;
		this.status = status;
		this.userId = userId;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
