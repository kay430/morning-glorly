package com.mg.jsp.mypage.model.dto;

import java.sql.Date;

public class MgOrderDeliveryDTO implements java.io.Serializable{
	
	
	private int deliveryNo;
	private String type;
	private int transitNo;
	private java.sql.Date deliveryDate;
	private int orderNo;
	
	public MgOrderDeliveryDTO() {
		
	}

	public MgOrderDeliveryDTO(int deliveryNo, String type, int transitNo, Date deliveryDate, int orderNo) {
		super();
		this.deliveryNo = deliveryNo;
		this.type = type;
		this.transitNo = transitNo;
		this.deliveryDate = deliveryDate;
		this.orderNo = orderNo;
	}

	public int getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(int deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTransitNo() {
		return transitNo;
	}

	public void setTransitNo(int transitNo) {
		this.transitNo = transitNo;
	}

	public java.sql.Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(java.sql.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "MgOrderDeliveryDTO [deliveryNo=" + deliveryNo + ", type=" + type + ", transitNo=" + transitNo
				+ ", deliveryDate=" + deliveryDate + ", orderNo=" + orderNo + "]";
	}
	

}
