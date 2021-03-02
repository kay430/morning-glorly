package com.mg.jsp.mypage.model.dto;

public class MgOrderGoodsDTO implements java.io.Serializable {
	
	private int orderNo;
	private int goodsNo;
	private int amountCount;
	private int orderGoodsPrice;

	public MgOrderGoodsDTO() {
		
	}

	public MgOrderGoodsDTO(int orderNo, int goodsNo, int amountCount, int orderGoodsPrice) {
		super();
		this.orderNo = orderNo;
		this.goodsNo = goodsNo;
		this.amountCount = amountCount;
		this.orderGoodsPrice = orderGoodsPrice;
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

	public int getOrderGoodsPrice() {
		return orderGoodsPrice;
	}

	public void setOrderGoodsPrice(int orderGoodsPrice) {
		this.orderGoodsPrice = orderGoodsPrice;
	}

	@Override
	public String toString() {
		return "MgOrderGoodsDTO [orderNo=" + orderNo + ", goodsNo=" + goodsNo + ", amountCount=" + amountCount
				+ ", orderGoodsPrice=" + orderGoodsPrice + "]";
	}
	
	
}
