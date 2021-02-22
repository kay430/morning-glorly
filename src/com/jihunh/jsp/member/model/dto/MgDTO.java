package com.jihunh.jsp.member.model.dto;

import java.sql.Date;

import com.jihunh.jsp.admin.model.dto.MemberAddress;
import com.jihunh.jsp.admin.model.dto.MemberBlackListDTO;
import com.jihunh.jsp.admin.model.dto.MemberModifyDTO;
import com.jihunh.jsp.admin.model.dto.MemberPointDTO;
import com.jihunh.jsp.payment.model.dto.PaymentDTO;

public class MgDTO implements java.io.Serializable {
	
	private int no;
	private String name;
	private String id;
	private String pwd;
	private String pno;
	private String gender;
	private String email;
	private String address;
	private String phone;
	private String subPhone;
	private int point;
	private java.sql.Date enrollDate;
	private java.sql.Date modifiedDate;
	private String blackList;
	private String status;
	private String nickname;			//- 이거 닉넹미 쓰는분 있습니까? 02/22(월) 지훈 -
	
	private MemberModifyDTO mgModify;
	private MemberBlackListDTO mgBlack;
	private MemberAddress mgAddress;
	private MemberPointDTO mgPoint;
	private PaymentDTO payInfo;
	/* 장바구니 추가되야함 */
	
	public MgDTO() {}

	public MgDTO(int no, String name, String id, String pwd, String pno, String gender, String email, String address,
			String phone, String subPhone, int point, Date enrollDate, Date modifiedDate, String blackList,
			String status, String nickname, MemberModifyDTO mgModify, MemberBlackListDTO mgBlack,
			MemberAddress mgAddress, MemberPointDTO mgPoint, PaymentDTO payInfo) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.pno = pno;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.subPhone = subPhone;
		this.point = point;
		this.enrollDate = enrollDate;
		this.modifiedDate = modifiedDate;
		this.blackList = blackList;
		this.status = status;
		this.nickname = nickname;
		this.mgModify = mgModify;
		this.mgBlack = mgBlack;
		this.mgAddress = mgAddress;
		this.mgPoint = mgPoint;
		this.payInfo = payInfo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSubPhone() {
		return subPhone;
	}

	public void setSubPhone(String subPhone) {
		this.subPhone = subPhone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public java.sql.Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(java.sql.Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getBlackList() {
		return blackList;
	}

	public void setBlackList(String blackList) {
		this.blackList = blackList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public MemberModifyDTO getMgModify() {
		return mgModify;
	}

	public void setMgModify(MemberModifyDTO mgModify) {
		this.mgModify = mgModify;
	}

	public MemberBlackListDTO getMgBlack() {
		return mgBlack;
	}

	public void setMgBlack(MemberBlackListDTO mgBlack) {
		this.mgBlack = mgBlack;
	}

	public MemberAddress getMgAddress() {
		return mgAddress;
	}

	public void setMgAddress(MemberAddress mgAddress) {
		this.mgAddress = mgAddress;
	}

	public MemberPointDTO getMgPoint() {
		return mgPoint;
	}

	public void setMgPoint(MemberPointDTO mgPoint) {
		this.mgPoint = mgPoint;
	}

	public PaymentDTO getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(PaymentDTO payInfo) {
		this.payInfo = payInfo;
	}

	@Override
	public String toString() {
		return "MgDTO [no=" + no + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", pno=" + pno + ", gender="
				+ gender + ", email=" + email + ", address=" + address + ", phone=" + phone + ", subPhone=" + subPhone
				+ ", point=" + point + ", enrollDate=" + enrollDate + ", modifiedDate=" + modifiedDate + ", blackList="
				+ blackList + ", status=" + status + ", nickname=" + nickname + ", mgModify=" + mgModify + ", mgBlack="
				+ mgBlack + ", mgAddress=" + mgAddress + ", mgPoint=" + mgPoint + ", payInfo=" + payInfo + "]";
	}

}
	
