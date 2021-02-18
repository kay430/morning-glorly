package com.jihunh.jsp.member.model.dto;

import java.sql.Date;

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
	private String point;
	private String memberPoint;
	private java.sql.Date enrollDate;
	private java.sql.Date modifiedDate;
	private String blackList;
	private String status;
	private String nickname;
	
	public MgDTO() {}

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

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(String memberPoint) {
		this.memberPoint = memberPoint;
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

	@Override
	public String toString() {
		return "MgDTO [no=" + no + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", pno=" + pno + ", gender="
				+ gender + ", email=" + email + ", address=" + address + ", phone=" + phone + ", subPhone=" + subPhone
				+ ", point=" + point + ", memberPoint=" + memberPoint + ", enrollDate=" + enrollDate + ", modifiedDate="
				+ modifiedDate + ", blackList=" + blackList + ", status=" + status + ", nickname=" + nickname + "]";
	}

	public MgDTO(int no, String name, String id, String pwd, String pno, String gender, String email, String address,
			String phone, String subPhone, String point, String memberPoint, Date enrollDate, Date modifiedDate,
			String blackList, String status, String nickname) {
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
		this.memberPoint = memberPoint;
		this.enrollDate = enrollDate;
		this.modifiedDate = modifiedDate;
		this.blackList = blackList;
		this.status = status;
		this.nickname = nickname;
	}

	
		
	}
	
