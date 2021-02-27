package com.jihunh.jsp.admin.model.dto;

import java.sql.Date;

public class MgAdDTO implements java.io.Serializable {
	
	private int no;
	private String name;
	private String id;
	private String pwd;
	private String pno;
	private String email;
	private java.sql.Date enrollDate;
	private String status;
	
	public MgAdDTO() {}

	public MgAdDTO(int no, String name, String id, String pwd, String pno, String email, Date enrollDate,
			String status) {
		super();
		this.no = no;
		this.name = name;
		this.id = id;
		this.pwd = pwd;
		this.pno = pno;
		this.email = email;
		this.enrollDate = enrollDate;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MgAdDTO [no=" + no + ", name=" + name + ", id=" + id + ", pwd=" + pwd + ", pno=" + pno + ", email="
				+ email + ", enrollDate=" + enrollDate + ", status=" + status + "]";
	}
	
}
