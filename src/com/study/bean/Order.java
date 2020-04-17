package com.study.bean;

import java.util.Date;

public class Order {
	
	//用户的订单号
	private String orderId;
	
	//订单的创建日期
	private Date createDate;
	
	//订单总金额
	private double totalMoney;
	
	//订单的状态
	private int status;
	
	//订单所关联的用户id
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
