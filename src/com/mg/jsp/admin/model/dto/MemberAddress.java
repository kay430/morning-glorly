package com.mg.jsp.admin.model.dto;

import com.jihunh.jsp.member.model.dto.MgDTO;

public class MemberAddress {
	
	private int no;
	private MgDTO mgNo;
	private String addName;			/* 주소 별칭 */
	private String recieverName;
	private String recieverPhone;
	private String recieverAddress;
	
	public MemberAddress() {};
	
	public MemberAddress(int no, MgDTO mgNo, String addName, String recieverName, String recieverPhone,
			String recieverAddress) {
		super();
		this.no = no;
		this.mgNo = mgNo;
		this.addName = addName;
		this.recieverName = recieverName;
		this.recieverPhone = recieverPhone;
		this.recieverAddress = recieverAddress;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public MgDTO getMgNo() {
		return mgNo;
	}

	public void setMgNo(MgDTO mgNo) {
		this.mgNo = mgNo;
	}

	public String getAddName() {
		return addName;
	}

	public void setAddName(String addName) {
		this.addName = addName;
	}

	public String getRecieverName() {
		return recieverName;
	}

	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
	}

	public String getRecieverPhone() {
		return recieverPhone;
	}

	public void setRecieverPhone(String recieverPhone) {
		this.recieverPhone = recieverPhone;
	}

	public String getRecieverAddress() {
		return recieverAddress;
	}

	public void setRecieverAddress(String recieverAddress) {
		this.recieverAddress = recieverAddress;
	}

	@Override
	public String toString() {
		return "MemberAddress [no=" + no + ", mgNo=" + mgNo + ", addName=" + addName + ", recieverName=" + recieverName
				+ ", recieverPhone=" + recieverPhone + ", recieverAddress=" + recieverAddress + "]";
	}
	
}
