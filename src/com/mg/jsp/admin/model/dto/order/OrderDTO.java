package com.mg.jsp.admin.model.dto.order;


import java.sql.Date;

public class OrderDTO implements java.io.Serializable {

	private int oNo;
	private int mNo;
	private Date oDate;
	private String oTitle;
	private int amount;
	
	public OrderDTO() {}

	public OrderDTO(int oNo, int mNo, Date oDate, String oTitle, int amount) {
		super();
		this.oNo = oNo;
		this.mNo = mNo;
		this.oDate = oDate;
		this.oTitle = oTitle;
		this.amount = amount;
	}

	public int getoNo() {
		return oNo;
	}

	public void setoNo(int oNo) {
		this.oNo = oNo;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public Date getoDate() {
		return oDate;
	}

	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}

	public String getoTitle() {
		return oTitle;
	}

	public void setoTitle(String oTitle) {
		this.oTitle = oTitle;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderDTO [oNo=" + oNo + ", mNo=" + mNo + ", oDate=" + oDate + ", oTitle=" + oTitle + ", amount="
				+ amount + "]";
	}


}