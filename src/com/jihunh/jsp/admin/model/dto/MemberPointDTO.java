package com.jihunh.jsp.admin.model.dto;

import java.sql.Date;

import com.jihunh.jsp.member.model.dto.MgDTO;
import com.jihunh.jsp.payment.model.dto.PaymentDTO;

public class MemberPointDTO {

	private int no;
	private String changedType;			//포인트 지급인지 사용인지 구분
	private PaymentDTO payInfo;			//사용한 경우 추적가능한 주문정보
	private java.sql.Date modifyDate;	//변경이력 날짜
	private int modifyPoint;			//변경 후 포인트
	private MgDTO mgInfo;
	
	public MemberPointDTO() {}

	public MemberPointDTO(int no, String changedType, PaymentDTO payInfo, Date modifyDate, int modifyPoint,
			MgDTO mgInfo) {
		super();
		this.no = no;
		this.changedType = changedType;
		this.payInfo = payInfo;
		this.modifyDate = modifyDate;
		this.modifyPoint = modifyPoint;
		this.mgInfo = mgInfo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getChangedType() {
		return changedType;
	}

	public void setChangedType(String changedType) {
		this.changedType = changedType;
	}

	public PaymentDTO getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(PaymentDTO payInfo) {
		this.payInfo = payInfo;
	}

	public java.sql.Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(java.sql.Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getModifyPoint() {
		return modifyPoint;
	}

	public void setModifyPoint(int modifyPoint) {
		this.modifyPoint = modifyPoint;
	}

	public MgDTO getMgInfo() {
		return mgInfo;
	}

	public void setMgInfo(MgDTO mgInfo) {
		this.mgInfo = mgInfo;
	}

	@Override
	public String toString() {
		return "MemberPointDTO [no=" + no + ", changedType=" + changedType + ", payInfo=" + payInfo + ", modifyDate="
				+ modifyDate + ", modifyPoint=" + modifyPoint + ", mgInfo=" + mgInfo + "]";
	}
	
}
