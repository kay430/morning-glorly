package com.mg.jsp.admin.model.dto.order;


import java.sql.Date;

public class OrderDTO implements java.io.Serializable {

	private int oNo;
	private int mNo;
	private Date oDate;
	private String oTitle;
	private int amount;
	private String mName;
	private String addr;
	private String phNo;
	private int gNo;
	private int aCount;
	private int oGPrice;
	
	public OrderDTO() {}

	public OrderDTO(int oNo, int mNo, Date oDate, String oTitle, int amount, String mName, String addr, String phNo,
			int gNo, int aCount, int oGPrice) {
		super();
		this.oNo = oNo;
		this.mNo = mNo;
		this.oDate = oDate;
		this.oTitle = oTitle;
		this.amount = amount;
		this.mName = mName;
		this.addr = addr;
		this.phNo = phNo;
		this.gNo = gNo;
		this.aCount = aCount;
		this.oGPrice = oGPrice;
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

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public int getgNo() {
		return gNo;
	}

	public void setgNo(int gNo) {
		this.gNo = gNo;
	}

	public int getaCount() {
		return aCount;
	}

	public void setaCount(int aCount) {
		this.aCount = aCount;
	}

	public int getoGPrice() {
		return oGPrice;
	}

	public void setoGPrice(int oGPrice) {
		this.oGPrice = oGPrice;
	}

	@Override
	public String toString() {
		return "OrderDTO [oNo=" + oNo + ", mNo=" + mNo + ", oDate=" + oDate + ", oTitle=" + oTitle + ", amount="
				+ amount + ", mName=" + mName + ", addr=" + addr + ", phNo=" + phNo + ", gNo=" + gNo + ", aCount="
				+ aCount + ", oGPrice=" + oGPrice + "]";
	}


}