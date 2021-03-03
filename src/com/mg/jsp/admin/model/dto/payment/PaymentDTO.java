package com.mg.jsp.admin.model.dto.payment;


import java.sql.Date;
import java.util.List;

public class PaymentDTO implements java.io.Serializable {

	private int pNo;
	private int oNo;
	private int mNo;
	private int amount;
	private int usedPoint;
	private String pType;
	private Date pDate;
	private String mName;
	private int phNo;
	private String mType;
	private String email;
	private int mPoint;
	
	public PaymentDTO() {}

	public PaymentDTO(int pNo, int oNo, int mNo, int amount, int usedPoint, String pType, Date pDate, String mName,
			int phNo, String mType, String email, int mPoint) {
		super();
		this.pNo = pNo;
		this.oNo = oNo;
		this.mNo = mNo;
		this.amount = amount;
		this.usedPoint = usedPoint;
		this.pType = pType;
		this.pDate = pDate;
		this.mName = mName;
		this.phNo = phNo;
		this.mType = mType;
		this.email = email;
		this.mPoint = mPoint;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getUsedPoint() {
		return usedPoint;
	}

	public void setUsedPoint(int usedPoint) {
		this.usedPoint = usedPoint;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	public Date getpDate() {
		return pDate;
	}

	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getPhNo() {
		return phNo;
	}

	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getmPoint() {
		return mPoint;
	}

	public void setmPoint(int mPoint) {
		this.mPoint = mPoint;
	}

	@Override
	public String toString() {
		return "PaymentDTO [pNo=" + pNo + ", oNo=" + oNo + ", mNo=" + mNo + ", amount=" + amount + ", usedPoint="
				+ usedPoint + ", pType=" + pType + ", pDate=" + pDate + ", mName=" + mName + ", phNo=" + phNo
				+ ", mType=" + mType + ", email=" + email + ", mPoint=" + mPoint + "]";
	}


}