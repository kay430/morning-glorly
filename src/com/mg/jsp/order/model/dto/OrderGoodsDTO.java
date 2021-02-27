package com.mg.jsp.order.model.dto;

import java.sql.Date;

import com.jihunh.jsp.member.model.dto.MgDTO;

public class OrderGoodsDTO implements java.io.Serializable {
		
	private int no;
	private MgDTO mgInfo;
	private java.sql.Date orderDate;
	private String orderTitle;
	private int amountPrice;
	
	public OrderGoodsDTO() {}

	public OrderGoodsDTO(int no, MgDTO mgInfo, Date orderDate, String orderTitle, int amountPrice) {
		super();
		this.no = no;
		this.mgInfo = mgInfo;
		this.orderDate = orderDate;
		this.orderTitle = orderTitle;
		this.amountPrice = amountPrice;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public MgDTO getMgInfo() {
		return mgInfo;
	}

	public void setMgInfo(MgDTO mgInfo) {
		this.mgInfo = mgInfo;
	}

	public java.sql.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderTitle() {
		return orderTitle;
	}

	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}

	public int getAmountPrice() {
		return amountPrice;
	}

	public void setAmountPrice(int amountPrice) {
		this.amountPrice = amountPrice;
	}

	@Override
	public String toString() {
		return "OrderGoodsDTO [no=" + no + ", mgInfo=" + mgInfo + ", orderDate=" + orderDate + ", orderTitle="
				+ orderTitle + ", amountPrice=" + amountPrice + "]";
	}
	
	
	}
	
