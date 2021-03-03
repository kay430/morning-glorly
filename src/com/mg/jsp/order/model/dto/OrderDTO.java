package com.mg.jsp.order.model.dto;

import java.sql.Date;
import java.util.List;

import com.mg.jsp.member.model.dto.MgAddressDTO;
import com.mg.jsp.member.model.dto.MgDTO;
import com.mg.jsp.payment.model.dto.PaymentDTO;
import com.mg.jsp.payment.model.dto.PaymentDivisionDTO;

public class OrderDTO implements java.io.Serializable {
		
	private int no;
	private MgDTO mgInfo;
	private java.sql.Date orderDate;
	private String orderTitle;
	private int amountPrice;
	private int existingPoint;
	
	private List<GoodOrderDTO> orderGoods;		//주문별 상품
	private List<OrderDeliveryDTO> orderDeli;	//주문별 배송
	private List<MgAddressDTO> mgAdd;			//회원별 배송지
	private List<OrderAddressDTO> orderAdd;			//배송 주소 구분
	private List<PaymentDTO> payment;			//결제
	private List<PaymentDivisionDTO> payDivi;	//결제구분
	
	public OrderDTO() {}

	public OrderDTO(int no, MgDTO mgInfo, Date orderDate, String orderTitle, int amountPrice, int existingPoint,
			List<GoodOrderDTO> orderGoods, List<OrderDeliveryDTO> orderDeli, List<MgAddressDTO> mgAdd,
			List<OrderAddressDTO> orderAdd, List<PaymentDTO> payment, List<PaymentDivisionDTO> payDivi) {
		super();
		this.no = no;
		this.mgInfo = mgInfo;
		this.orderDate = orderDate;
		this.orderTitle = orderTitle;
		this.amountPrice = amountPrice;
		this.existingPoint = existingPoint;
		this.orderGoods = orderGoods;
		this.orderDeli = orderDeli;
		this.mgAdd = mgAdd;
		this.orderAdd = orderAdd;
		this.payment = payment;
		this.payDivi = payDivi;
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

	public int getExistingPoint() {
		return existingPoint;
	}

	public void setExistingPoint(int existingPoint) {
		this.existingPoint = existingPoint;
	}

	public List<GoodOrderDTO> getOrderGoods() {
		return orderGoods;
	}

	public void setOrderGoods(List<GoodOrderDTO> orderGoods) {
		this.orderGoods = orderGoods;
	}

	public List<OrderDeliveryDTO> getOrderDeli() {
		return orderDeli;
	}

	public void setOrderDeli(List<OrderDeliveryDTO> orderDeli) {
		this.orderDeli = orderDeli;
	}

	public List<MgAddressDTO> getMgAdd() {
		return mgAdd;
	}

	public void setMgAdd(List<MgAddressDTO> mgAdd) {
		this.mgAdd = mgAdd;
	}

	public List<OrderAddressDTO> getOrderAdd() {
		return orderAdd;
	}

	public void setOrderAdd(List<OrderAddressDTO> orderAdd) {
		this.orderAdd = orderAdd;
	}

	public List<PaymentDTO> getPayment() {
		return payment;
	}

	public void setPayment(List<PaymentDTO> payment) {
		this.payment = payment;
	}

	public List<PaymentDivisionDTO> getPayDivi() {
		return payDivi;
	}

	public void setPayDivi(List<PaymentDivisionDTO> payDivi) {
		this.payDivi = payDivi;
	}

	@Override
	public String toString() {
		return "OrderDTO [no=" + no + ", mgInfo=" + mgInfo + ", orderDate=" + orderDate + ", orderTitle=" + orderTitle
				+ ", amountPrice=" + amountPrice + ", existingPoint=" + existingPoint + ", orderGoods=" + orderGoods
				+ ", orderDeli=" + orderDeli + ", mgAdd=" + mgAdd + ", orderAdd=" + orderAdd + ", payment=" + payment
				+ ", payDivi=" + payDivi + "]";
	}

	
	}
	
