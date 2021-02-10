package com.jihunh.jsp.member.model.dto;

import java.sql.Date;

public class MgDTO implements java.io.Serializable {
	
	private int no;
	private String name;
	private String id;
	private String pwd;
	private String pno;
	private String gender;
	private String address;
	private String email;
	private String phone;
	private java.sql.Date enrollDate;
	private String role;
	private String status;
	
	public MgDTO() {}

	public MgDTO(int no, String name, String id, String pwd, String pno, String gender, String address, String email,
			String phone, Date enrollDate, String role, String status) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.pno = pno;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.enrollDate = enrollDate;
		this.role = role;
		this.status = status;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MgDTO [no=" + no + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", pno=" + pno + ", gender="
				+ gender + ", address=" + address + ", email=" + email + ", phone=" + phone + ", enrollDate="
				+ enrollDate + ", role=" + role + ", status=" + status + "]";
	}
	
}
