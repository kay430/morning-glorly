package com.mg.jsp.admin.model.dto;

import java.sql.Date;

import com.mg.jsp.member.model.dto.MgDTO;

public class MemberBlackListDTO {

	private int no;
	private java.sql.Date createdDate;
	private String reasonInfo;
	private String status;
	private MgDTO mgNo;
	
	public MemberBlackListDTO() {};
	
	public MemberBlackListDTO(int no, Date createdDate, String reasonInfo, String status, MgDTO mgNo) {
		super();
		this.no = no;
		this.createdDate = createdDate;
		this.reasonInfo = reasonInfo;
		this.status = status;
		this.mgNo = mgNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public java.sql.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.sql.Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getReasonInfo() {
		return reasonInfo;
	}

	public void setReasonInfo(String reasonInfo) {
		this.reasonInfo = reasonInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MgDTO getMgNo() {
		return mgNo;
	}

	public void setMgNo(MgDTO mgNo) {
		this.mgNo = mgNo;
	}

	@Override
	public String toString() {
		return "MemberBlackListDTO [no=" + no + ", createdDate=" + createdDate + ", reasonInfo=" + reasonInfo
				+ ", status=" + status + ", mgNo=" + mgNo + "]";
	}
	
}
