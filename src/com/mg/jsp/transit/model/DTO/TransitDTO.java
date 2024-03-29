package com.mg.jsp.transit.model.DTO;


import java.sql.Date;
import java.util.List;

public class TransitDTO implements java.io.Serializable {

	private int dNo;
	private String dType;
	private int tNo;
	private int newTNo;
	private Date tDate;
	private int oNo;
	private int memberNo;
	private Date oDate;
	private String oTitle;
	private int price;

	public TransitDTO() {}

	public TransitDTO(int dNo, String dType, int tNo, int newTNo, Date tDate, int oNo, int memberNo, Date oDate,
			String oTitle, int price) {
		super();
		this.dNo = dNo;
		this.dType = dType;
		this.tNo = tNo;
		this.newTNo = newTNo;
		this.tDate = tDate;
		this.oNo = oNo;
		this.memberNo = memberNo;
		this.oDate = oDate;
		this.oTitle = oTitle;
		this.price = price;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String getdType() {
		return dType;
	}

	public void setdType(String dType) {
		this.dType = dType;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public int getnewTNo() {
		return newTNo;
	}

	public void setnewTNo(int newTNo) {
		this.newTNo = newTNo;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	public int getoNo() {
		return oNo;
	}

	public void setoNo(int oNo) {
		this.oNo = oNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TransitDTO [dNo=" + dNo + ", dType=" + dType + ", tNo=" + tNo + ", newTNo=" + newTNo + ", tDate="
				+ tDate + ", oNo=" + oNo + ", memberNo=" + memberNo + ", oDate=" + oDate + ", oTitle=" + oTitle
				+ ", price=" + price + "]";
	}


}