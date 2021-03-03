package com.mg.jsp.order.model.dto;

import java.sql.Date;

import com.mg.jsp.member.model.dto.MgDTO;

public class GoodOrderDTO implements java.io.Serializable {
		
	private int orderNo;
	private int goodsNo;
	private int amountCount;
	private int goodsPrice;
	
	public GoodOrderDTO() {}

	public GoodOrderDTO(int orderNo, int goodsNo, int amountCount, int goodsPrice) {
		super();
		this.orderNo = orderNo;
		this.goodsNo = goodsNo;
		this.amountCount = amountCount;
		this.goodsPrice = goodsPrice;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}

	public int getAmountCount() {
		return amountCount;
	}

	public void setAmountCount(int amountCount) {
		this.amountCount = amountCount;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	@Override
	public String toString() {
		return "OrderGoodsDTO [orderNo=" + orderNo + ", goodsNo=" + goodsNo + ", amountCount=" + amountCount
				+ ", goodsPrice=" + goodsPrice + "]";
	}
	
	
	}
	
