package com.mg.jsp.admin.model.dto;

import java.sql.Date;

import com.mg.jsp.member.model.dto.MgDTO;

public class MemberModifyDTO {
	
	private int no;
	private String column;
	private String originInfo;
	private String modifyInfo;
	private java.sql.Date modifiedDate;
	private MgDTO mgNo;
	
	public MemberModifyDTO() {};
	
	public MemberModifyDTO(int no, String column, String originInfo, String modifyInfo, Date modifiedDate, MgDTO mgNo) {
		super();
		this.no = no;
		this.column = column;
		this.originInfo = originInfo;
		this.modifyInfo = modifyInfo;
		this.modifiedDate = modifiedDate;
		this.mgNo = mgNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getOriginInfo() {
		return originInfo;
	}

	public void setOriginInfo(String originInfo) {
		this.originInfo = originInfo;
	}

	public String getModifyInfo() {
		return modifyInfo;
	}

	public void setModifyInfo(String modifyInfo) {
		this.modifyInfo = modifyInfo;
	}

	public java.sql.Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(java.sql.Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public MgDTO getMgNo() {
		return mgNo;
	}

	public void setMgNo(MgDTO mgNo) {
		this.mgNo = mgNo;
	}

	@Override
	public String toString() {
		return "MemberModifyDTO [no=" + no + ", column=" + column + ", originInfo=" + originInfo + ", modifyInfo="
				+ modifyInfo + ", modifiedDate=" + modifiedDate + ", mgNo=" + mgNo + "]";
	}
	
}
