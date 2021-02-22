package com.jihunh.jsp.payment.model.dto;

import java.sql.Date;

import com.jihunh.jsp.member.model.dto.MgDTO;
import com.jihunh.jsp.order.model.dto.OrderGoodsDTO;

public class PaymentDTO implements java.io.Serializable {
		
	private int no;
	private OrderGoodsDTO orderInfo;
	private MgDTO mgInfo;
	private int finalPrice;
	private int usedPoint;
	private String status;
	private java.sql.Date PaymentDate;
	
	public PaymentDTO() {}

	public PaymentDTO(int no, OrderGoodsDTO orderInfo, MgDTO mgInfo, int finalPrice, int usedPoint, String status,
			Date paymentDate) {
		super();
		this.no = no;
		this.orderInfo = orderInfo;
		this.mgInfo = mgInfo;
		this.finalPrice = finalPrice;
		this.usedPoint = usedPoint;
		this.status = status;
		PaymentDate = paymentDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public OrderGoodsDTO getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderGoodsDTO orderInfo) {
		this.orderInfo = orderInfo;
	}

	public MgDTO getMgInfo() {
		return mgInfo;
	}

	public void setMgInfo(MgDTO mgInfo) {
		this.mgInfo = mgInfo;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	public int getUsedPoint() {
		return usedPoint;
	}

	public void setUsedPoint(int usedPoint) {
		this.usedPoint = usedPoint;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.sql.Date getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(java.sql.Date paymentDate) {
		PaymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "PaymentDTO [no=" + no + ", orderInfo=" + orderInfo + ", mgInfo=" + mgInfo + ", finalPrice=" + finalPrice
				+ ", usedPoint=" + usedPoint + ", status=" + status + ", PaymentDate=" + PaymentDate + "]";
	}
	
	
	}
	
