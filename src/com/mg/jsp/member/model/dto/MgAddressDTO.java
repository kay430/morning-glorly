package com.mg.jsp.member.model.dto;

public class MgAddressDTO {

	private int no;
	private int memNo;
	private String addName;
	private String recieverName;
	private String recieverPhone;
	private String recieverAddress;
	
	public MgAddressDTO() {}

	public MgAddressDTO(int no, int memNo, String addName, String recieverName, String recieverPhone,
			String recieverAddress) {
		super();
		this.no = no;
		this.memNo = memNo;
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

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
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
		return "MgAddressDTO [no=" + no + ", memNo=" + memNo + ", addName=" + addName + ", recieverName=" + recieverName
				+ ", recieverPhone=" + recieverPhone + ", recieverAddress=" + recieverAddress + "]";
	}
	
}
